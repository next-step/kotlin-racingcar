package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.scopes.BehaviorSpecGivenContainerScope
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class OperatorTest : BehaviorSpec({

    given("연산자 기호와 연산자 기대 객체가 주어졌을 때") {
        listOf(
            "+" to Operator.ADDITION,
            "-" to Operator.SUBTRACTION,
            "*" to Operator.MULTIPLICATION,
            "/" to Operator.DIVISION,
        ).forAll { (symbol, expected) ->
            `when`("$symbol 기호로 연산자를 찾게되면") {
                val operator = Operator.of(symbol)
                then("${expected}가 반환된다") {
                    operator shouldBe expected
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

        listOf(
            Pair(0, 0) to 0,
            Pair(0, 10) to 10,
            Pair(11, 18) to 29,
            Pair(0, 6) to 6,
        ).forAll { (numbers, expected) ->
            `연산적용 후 검증`(numbers, operator, expected)
        }
    }

    given("두 숫자와 뺄셈 기대 값이 주어졌을 때") {
        val operator = Operator.SUBTRACTION
        listOf(
            Pair(0, 0) to 0,
            Pair(0, 10) to -10,
            Pair(18, 11) to 7,
            Pair(0, 6) to -6
        ).forAll { (numbers, expected) ->
            `연산적용 후 검증`(numbers, operator, expected)
        }
    }

    given("두 숫자와 곱셈 기대 값이 주어졌을 때") {
        val operator = Operator.MULTIPLICATION
        listOf(
            Pair(0, 0) to 0,
            Pair(0, 10) to 0,
            Pair(11, 18) to 198,
            Pair(13, 5) to 65,
        ).forAll { (numbers, expected) ->
            `연산적용 후 검증`(numbers, operator, expected)
        }
    }

    given("두 숫자와 나눗셈 기대 값이 주어졌을 때") {
        val operator = Operator.DIVISION
        listOf(
            Pair(0, 10) to 0,
            Pair(33, 3) to 11,
            Pair(48, 5) to 9,
        ).forAll { (numbers, expected) ->
            `연산적용 후 검증`(numbers, operator, expected)
        }
    }

    given("두 숫자 중 두 번째 수가 0이 주어졌을 때") {
        val first = 6
        val second = 0
        `when`("나눗셈 연산을 수행하면") {
            then("예외가 발생한다") {
                shouldThrow<IllegalArgumentException> {
                    Operator.DIVISION.calculate(first, second)
                }
            }
        }
    }
})

private suspend fun BehaviorSpecGivenContainerScope.`연산적용 후 검증`(
    numbers: Pair<Int, Int>,
    operator: Operator,
    expected: Int
) {
    `when`("${numbers.first}, ${numbers.second}에 ${operator}를 적용하면") {
        val actual = operator.calculate(numbers.first, numbers.second)
        then("${expected}이 반환된다") {
            actual shouldBe expected
        }
    }
}
