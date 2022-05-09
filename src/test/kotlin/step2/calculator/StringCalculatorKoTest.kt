package step2.calculator

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StringCalculatorKoTest : DescribeSpec({
    describe("StringCalculator") {
        context("계산식") {
            it("덧셈") {
                repeat(10) {
                    val first = (1..9).random()
                    val second = (1..9).random()
                    val third = (1..9).random()
                    val result = Calculator.calculate("$first + $second + $third")

                    result shouldBe first.plus(second).plus(third)
                }
            }

            it("곱셈") {
                repeat(10) {
                    val first = (1..9).random()
                    val second = (1..9).random()
                    val third = (1..9).random()
                    val result = Calculator.calculate("$first * $second * $third")

                    result shouldBe first.times(second).times(third)
                }
            }

            it("뺄셈") {
                repeat(10) {
                    val first = (1..9).random()
                    val second = (1..9).random()
                    val third = (1..9).random()
                    val result = Calculator.calculate("$first - $second - $third")

                    result shouldBe first.minus(second).minus(third)
                }
            }

            it("나눗셈") {
                repeat(10) {
                    val first = (8..9).random()
                    val second = (1..2).random()
                    val third = (1..2).random()
                    val result = Calculator.calculate("$first / $second / $third")

                    result shouldBe first.div(second).div(third)
                }
            }
        }
    }
})
