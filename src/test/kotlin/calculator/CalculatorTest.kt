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

                calculator.total shouldBe 5L
                secondCalculator.total shouldBe 8L
            }
        }

        describe("subtraction") {
            it("계산식에 - 연산자가 있다면 뺄셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 - 2")
                secondCalculator.calculate("3 - 3 - 2")

                calculator.total shouldBe 1L
                secondCalculator.total shouldBe -2L
            }
        }
    }
})
