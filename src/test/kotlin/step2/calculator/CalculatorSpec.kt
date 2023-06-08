package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorSpec : DescribeSpec({

    describe("계산기 테스트") {
        context("수식 : 2 + 3 * 4 / 2") {
            it("결과 : 10") {
                val expression = "2 + 3 * 4 / 2"
                val result = Calculator.calculate(expression)

                result shouldBe 10
            }
        }

        context("수식 : 2 * 3 + 4 / 2") {
            it("결과 : 5") {
                val expression = "2 * 3 + 4 / 2"
                val result = Calculator.calculate(expression)

                result shouldBe 5
            }
        }

        context("수식 : \"\"") {
            it("결과 : IllegalArgumentException") {
                val expression = ""

                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate("")
                }
            }
        }

        context("수식 : 2 + 3 * ( 4 / 2 )") {
            it("결과 : IllegalArgumentException") {
                val expression = "2 + 3 * ( 4 / 2 )"
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate(expression)
                }
            }
        }

        context("수식 : 2 +") {
            it("결과 : IllegalArgumentException") {
                val expression = "2 +"
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate(expression)
                }
            }
        }

        context("수식 : a + b") {
            it("결과 : IllegalArgumentException") {
                val expression = "a + b"
                shouldThrow<IllegalArgumentException> {
                    Calculator.calculate(expression)
                }
            }
        }
    }
})
