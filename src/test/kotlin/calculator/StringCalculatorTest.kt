package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("StringCalculator의") {
        context("calculate 함수를 호출할 때") {
            test("입력값이 null이면 예외가 발생한다.") {
                // given
                val input = null

                // when then
                val exception = shouldThrow<IllegalArgumentException> {
                    StringCalculator.calculate(input)
                }
                exception.message shouldBe "문자열 계산기의 입력값은 null이거나 빈 값일 수 없습니다. input: null"
            }

            test("입력값이 빈 값이면 예외가 발생한다.") {
                // given
                val input = ""

                // when then
                val exception = shouldThrow<IllegalArgumentException> {
                    StringCalculator.calculate(input)
                }
                exception.message shouldBe "문자열 계산기의 입력값은 null이거나 빈 값일 수 없습니다. input: "
            }

            test("입력값이 공백이면 예외가 발생한다.") {
                // given
                val input = "   "

                // when then
                val exception = shouldThrow<IllegalArgumentException> {
                    StringCalculator.calculate(input)
                }
                exception.message shouldBe "문자열 계산기의 입력값은 null이거나 빈 값일 수 없습니다. input:    "
            }

            test("문자열 덧셈이 가능하다.") {
                // given
                val input = "1 + 1"

                // when
                val result: String = StringCalculator.calculate(input)

                // then
                result shouldBe "2"
            }

            test("문자열 뺄 셈이 가능하다.") {
                // given
                val input = "2 - 1"

                // when
                val result: String = StringCalculator.calculate(input)

                // then
                result shouldBe "1"
            }

            test("문자열 곱셈이 가능하다.") {
                // given
                val input = "3 * 2"

                // when
                val result: String = StringCalculator.calculate(input)

                // then
                result shouldBe "6"
            }

            test("문자열 나눗셈이 가능하다.") {
                // given
                val input = "10 / 2"

                // when
                val result: String = StringCalculator.calculate(input)

                // then
                result shouldBe "5"
            }
        }
    }
})
