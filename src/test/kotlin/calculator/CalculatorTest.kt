package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("calculate") {
        it("계산식에 + 연산자가 있다면 더하기를 수행한다.") {
            val calculator = Calculator
            val secondCalculator = Calculator

            val result = calculator.calculate("3 + 2")
            val secondResult = secondCalculator.calculate("3 + 3 + 2")

            result shouldBe 5
            secondResult shouldBe 8
        }

        it("계산식에 - 연산자가 있다면 뺄셈을 수행한다.") {
            val calculator = Calculator
            val secondCalculator = Calculator

            val result = calculator.calculate("3 - 2")
            val secondResult = secondCalculator.calculate("3 - 3 - 2")

            result shouldBe 1
            secondResult shouldBe -2
        }

        it("계산식에 * 연산자가 있다면 곱셈을 수행한다.") {
            val calculator = Calculator
            val secondCalculator = Calculator

            val result = calculator.calculate("3 * 2")
            val secondResult = secondCalculator.calculate("3 * 3 * 2")

            result shouldBe 6
            secondResult shouldBe 18
        }

        it("계산식에 / 연산자가 있다면 나눗셈을 수행한다.") {
            val calculator = Calculator
            val secondCalculator = Calculator

            val result = calculator.calculate("3 / 2")
            val secondResult = secondCalculator.calculate("9 / 3 / 3")

            result shouldBe 1.5
            secondResult shouldBe 1
        }

        it("여러 operator 에 따른 계산식을 수행한다.") {
            val calculator = Calculator

            val result = calculator.calculate("5 + 2 * 3 - 1")

            result shouldBe 20
        }

        context("with invalid operator") {
            it("IllegalArgumentException 에러를 발생시킨다.") {
                val calculator = Calculator

                val exception = shouldThrow<IllegalArgumentException> {
                    calculator.calculate("3 & 3")
                }

                exception.message shouldBe "유효하지 않은 연산자 입니다."
            }
        }
    }
})
