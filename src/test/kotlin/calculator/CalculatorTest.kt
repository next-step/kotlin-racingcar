package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : DescribeSpec({
    describe("Calculator") {
        it("더하기를 수행한다.") {
            val calculator = Calculator()

            val result = calculator.calculate("1 + 2")
            val result2 = calculator.calculate("1 + 2 + 3")

            result shouldBe 3
            result2 shouldBe 6
        }

        it("빼기를 수행한다.") {
            val calculator = Calculator()

            val result = calculator.calculate("2 - 1")
            val result2 = calculator.calculate("10 - 2 - 2")

            result shouldBe 1
            result2 shouldBe 6
        }

        it("곱셈를 수행한다.") {
            val calculator = Calculator()

            val result = calculator.calculate("2 * 2")
            val result2 = calculator.calculate("10 * 2 * 2")

            result shouldBe 4
            result2 shouldBe 40
        }

        it("나눗셈를 수행한다.") {
            val calculator = Calculator()

            val result = calculator.calculate("4 / 2")
            val result2 = calculator.calculate("12 / 2 / 2")
            val result3 = calculator.calculate("10 / 2 / 2")

            result shouldBe 2
            result2 shouldBe 3
            result3 shouldBe 2.5
        }

        it("사칙연산을 수행한다.") {
            val calculator = Calculator()

            val result = calculator.calculate("4 + 2 - 1")
            val result2 = calculator.calculate("12 + 2 / 7")
            val result3 = calculator.calculate("10 + 2 - 2 * 2 / 2")

            result shouldBe 5
            result2 shouldBe 2
            result3 shouldBe 10
        }

        context("사칙연산 기호가 아닌 경우") {
            it("IllegalArgumentException 에러가 발생한다.") {

                val calculator = Calculator()

                val exception = shouldThrow<IllegalArgumentException> {
                    calculator.calculate("4 $ 2")
                }

                exception.message shouldBe "사칙연산 기호가 아닙니다."
            }
        }

        context("입력값이 null 이거나 빈 공백 문자일 경우") {
            it("IllegalArgumentException 에러가 발생한다.") {
                val calculator = Calculator()

                val exception1 = shouldThrow<IllegalArgumentException> {
                    calculator.calculate("")
                }
                val exception2 = shouldThrow<IllegalArgumentException> {
                    calculator.calculate(null)
                }

                exception1.message shouldBe "올바은 계산식이 아닙니다."
                exception2.message shouldBe "올바은 계산식이 아닙니다."
            }
        }

        describe("groupByIsNumber") {
            it("true 를 받으면 숫자 배열만 리턴한다.") {
                val inputs = listOf<String>("1", "+", "2", "-", "3")
                val inputs2 = listOf<String>("1", "+", "2", "-", "3", "4")

                val calculator = Calculator()

                val result = calculator.groupByIsNumber(inputs, true)
                val result2 = calculator.groupByIsNumber(inputs2, true)

                result shouldBe listOf<String>("1", "2", "3")
                result2 shouldBe listOf<String>("1", "2", "3", "4")
            }

            it("false 를 받으면 숫자가 아닌 요소 배열만 리턴한다.") {
                val inputs = listOf<String>("1", "+", "2", "-", "3")
                val inputs2 = listOf<String>("1", "+", "2", "-", "3", "4")

                val calculator = Calculator()

                val result = calculator.groupByIsNumber(inputs, false)
                val result2 = calculator.groupByIsNumber(inputs2, false)

                result shouldBe listOf<String>("+", "-")
                result2 shouldBe listOf<String>("+", "-")
            }
        }
    }
})
