package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({

    given("연산자 기호와 연산자 기대 객체가 주어졌을 때") {
        val parameters = listOf(
            Pair("+", Operator.ADDITION),
            Pair("-", Operator.SUBTRACTION),
            Pair("*", Operator.MULTIPLICATION),
            Pair("/", Operator.DIVISION)
        )

        parameters.forEach {
            `when`("${it.first} 기호로 연산자를 찾게되면") {
                val operator = Operator.of(it.first)
                then("${it.second}가 반환된다") {
                    operator shouldBe it.second
                }
            }
        }
    }

    given("잘못된 연산자 기호가 주어졌을 때") {
        val wrongSymbol = "^"
        `when`("{$wrongSymbol} 기호로 연산자를 찾게 되면") {
            then("예외가 발생한다") {
                shouldThrow<java.lang.IllegalArgumentException> {
                    Operator.of(wrongSymbol)
                }
            }
        }
    }

    given("두 숫자와 덧셈 기대 값이 주어졌을 때") {
        val operator = Operator.ADDITION
        val parameters = listOf(
            Triple(0, 0, 0),
            Triple(0, 10, 10),
            Triple(11, 18, 29),
            Triple(0, 6, 6),
        )

        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자와 뺄셈 기대 값이 주어졌을 때") {
        val operator = Operator.SUBTRACTION
        val parameters = listOf(
            Triple(0, 0, 0),
            Triple(0, 10, -10),
            Triple(18, 11, 7),
            Triple(0, 6, -6),
        )


        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자와 곱셈 기대 값이 주어졌을 때") {
        val operator = Operator.MULTIPLICATION
        val parameters = listOf(
            Triple(0, 0, 0),
            Triple(0, 10, 0),
            Triple(11, 18, 198),
            Triple(13, 5, 65),
        )


        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자와 나눗셈 기대 값이 주어졌을 때") {
        val operator = Operator.DIVISION
        val parameters = listOf(
            Triple(0, 10, 0),
            Triple(33, 3, 11),
            Triple(48, 5, 9),
        )

        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자 중 두 번째 수가 0이 주어졌을 때") {
        val wrongParameter = Pair(6, 0)
        `when`("나눗셈 연산을 수행하면") {
            then("예외가 발생한다") {
                shouldThrow<java.lang.ArithmeticException> {
                    Operator.DIVISION.calculate(wrongParameter.first, wrongParameter.second)
                }
            }
        }
    }
})

private suspend fun BehaviorSpecGivenContainerScope.`연산 적용 후 검증`(
    parameters: List<Triple<Int, Int, Int>>,
    operator: Operator
) {
    parameters.forEach {
        `when`("${it.first}, ${it.second}에 ${operator}를 적용하면") {
            val actual = operator.calculate(it.first, it.second)
            then("${it.third}이 반환된다") {
                actual shouldBe it.third
            }
        }
    }
}