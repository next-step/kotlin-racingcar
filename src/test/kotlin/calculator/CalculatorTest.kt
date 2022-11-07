package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class CalculatorTest : ExpectSpec({

    context("Calculator.calculate") {
        expect("returns") {
            calculations.forAll { (arg, result) ->
                Calculator.calculate(arg) shouldBe result
            }
        }

        expect("소숫점자리를 절삭한 결과를 반환한다 ") {
            Calculator.calculate("3 / 1") shouldBe "3"
        }

        expect("operator 가 없는 경우 바로 반환한다") {
            Calculator.calculate("2") shouldBe "2"
        }

        expect("fail if contain unsupported operand") {
            val ex = shouldThrow<IllegalArgumentException> {
                Calculator.calculate("1 + 2 ! 1")
            }
            ex.message shouldBe "Unsupported Operator [!]"
        }
        expect("fail if divide by zero") {
            shouldThrowExactly<ArithmeticException> {
                Calculator.calculate("3 / 0")
            }
        }
        expect("fail if overflow") {
            shouldThrowExactly<ArithmeticException> {
                Calculator.calculate(Long.MAX_VALUE.toString() + " + " + Long.MAX_VALUE.toString())
            }
        }

        expect("fail if underflow") {
            shouldThrow<ArithmeticException> {
                Calculator.calculate(Long.MIN_VALUE.toString() + " + " + Long.MIN_VALUE.toString())
            }
        }

        expect("fail if operand is number") {
            shouldThrow<NumberFormatException> {
                Calculator.calculate("2a + 3")
            }
        }

        expect("fail if invalid operator, operand pairs") {
            val ex = shouldThrow<IllegalArgumentException> {
                Calculator.calculate("2 + 1 +")
            }
            ex.message shouldBe "Invalid Input"
        }

        expect("모든 operand 는 Long 범위 안의 숫자여야한다") {
            shouldThrow<NumberFormatException> {
                Calculator.calculate("9223372036854775809 + 3")
            }
        }
    }
}) {
    companion object {
        val calculations = listOf(
            "2 + 3 * 4 / 2" to "10",
            "1 + 2 - 1" to "2",
            "10 * 10 * 10" to "1000"
        )
    }
}
