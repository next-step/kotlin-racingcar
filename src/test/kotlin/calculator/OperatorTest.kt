package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({

    given("연산자 기호와 연산자 기대 객체가 주어졌을 때") {
        val parameters = listOf(
            OperatorFixture("+", Operator.ADDITION),
            OperatorFixture("-", Operator.SUBTRACTION),
            OperatorFixture("*", Operator.MULTIPLICATION),
            OperatorFixture("/", Operator.DIVISION)
        )

        parameters.forEach {
            `when`("${it.symbol} 기호로 연산자를 찾게되면") {
                val operator = Operator.of(it.symbol)
                then("${it.operator}가 반환된다") {
                    operator shouldBe it.operator
                }
            }
        }
    }

    given("잘못된 연산자 기호가 주어졌을 때") {
        val wrongSymbol = "^"
        `when`("{$wrongSymbol} 기호로 연산자를 찾게 되면") {
            then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Operator.of(wrongSymbol)
                }
            }
        }
    }

    given("두 숫자와 덧셈 기대 값이 주어졌을 때") {
        val operator = Operator.ADDITION
        val parameters = listOf(
            OperationFixture(0, 0, 0),
            OperationFixture(0, 10, 10),
            OperationFixture(11, 18, 29),
            OperationFixture(0, 6, 6),
        )

        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자와 뺄셈 기대 값이 주어졌을 때") {
        val operator = Operator.SUBTRACTION
        val parameters = listOf(
            OperationFixture(0, 0, 0),
            OperationFixture(0, 10, -10),
            OperationFixture(18, 11, 7),
            OperationFixture(0, 6, -6),
        )

        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자와 곱셈 기대 값이 주어졌을 때") {
        val operator = Operator.MULTIPLICATION
        val parameters = listOf(
            OperationFixture(0, 0, 0),
            OperationFixture(0, 10, 0),
            OperationFixture(11, 18, 198),
            OperationFixture(13, 5, 65),
        )

        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자와 나눗셈 기대 값이 주어졌을 때") {
        val operator = Operator.DIVISION
        val parameters = listOf(
            OperationFixture(0, 10, 0),
            OperationFixture(33, 3, 11),
            OperationFixture(48, 5, 9),
        )

        `연산 적용 후 검증`(parameters, operator)
    }

    given("두 숫자 중 두 번째 수가 0이 주어졌을 때") {
        val first = 6
        val second = 0
        `when`("나눗셈 연산을 수행하면") {
            then("예외가 발생한다") {
                shouldThrow<java.lang.ArithmeticException> {
                    Operator.DIVISION.calculate(first, second)
                }
            }
        }
    }
})

private suspend fun BehaviorSpecGivenContainerScope.`연산 적용 후 검증`(
    parameters: List<OperationFixture>,
    operator: Operator
) {
    parameters.forEach {
        `when`("${it.first}, ${it.second}에 ${operator}를 적용하면") {
            val actual = operator.calculate(it.first, it.second)
            then("${it.expected}이 반환된다") {
                actual shouldBe it.expected
            }
        }
    }
}
