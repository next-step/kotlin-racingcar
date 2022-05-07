package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("Calculator") {
        describe("calculate") {
            it("계산식에 + 연산자가 있다면 더하기를 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 + 2")
                secondCalculator.calculate("3 + 3 + 2")

                calculator.total shouldBe 5
                secondCalculator.total shouldBe 8
            }

            it("계산식에 - 연산자가 있다면 뺄셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 - 2")
                secondCalculator.calculate("3 - 3 - 2")

                calculator.total shouldBe 1
                secondCalculator.total shouldBe -2
            }

            it("계산식에 * 연산자가 있다면 곱셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 * 2")
                secondCalculator.calculate("3 * 3 * 2")

                calculator.total shouldBe 6
                secondCalculator.total shouldBe 18
            }

            it("계산식에 / 연산자가 있다면 나눗셈을 수행한다.") {
                val calculator = Calculator()
                val secondCalculator = Calculator()

                calculator.calculate("3 / 2")
                secondCalculator.calculate("9 / 3 / 3")

                calculator.total shouldBe 1.5
                secondCalculator.total shouldBe 1
            }

            context("with invalid operator") {
                it("IllegalArgumentException 에러를 발생시킨다.") {
                    val calculator = Calculator()

                    val exception = shouldThrow<IllegalArgumentException> {
                        calculator.calculate("3 & 3")
                    }

                    exception.message shouldBe "유효하지 않은 연산자 입니다."
                }
            }
        }
    }
})
