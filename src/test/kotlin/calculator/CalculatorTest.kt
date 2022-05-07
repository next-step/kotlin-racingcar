package calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("Calculator") {
        describe("addition") {
            it("계산식에 + 연산자가 있다면 더하기를 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 + 2")
                secondCalculator.calculate("3 + 3 + 2")

                calculator.total shouldBe 5
                secondCalculator.total shouldBe 8
            }
        }

        describe("subtraction") {
            it("계산식에 - 연산자가 있다면 뺄셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 - 2")
                secondCalculator.calculate("3 - 3 - 2")

                calculator.total shouldBe 1
                secondCalculator.total shouldBe -2
            }
        }

        describe("multiplication") {
            it("계산식에 * 연산자가 있다면 곱셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 * 2")
                secondCalculator.calculate("3 * 3 * 2")

                calculator.total shouldBe 6
                secondCalculator.total shouldBe 18
            }
        }

        describe("division") {
            it("계산식에 / 연산자가 있다면 나눗셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 / 2")
                secondCalculator.calculate("9 / 3 / 3")

                calculator.total shouldBe 1.5
                secondCalculator.total shouldBe 1
            }
        }
    }
})
