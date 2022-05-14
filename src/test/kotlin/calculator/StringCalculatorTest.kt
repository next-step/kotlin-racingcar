package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("문자열 계산기를 실행할 때") {
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

        test("입력값에 숫자로 변환할 수 없는 문자열이 들어간다면 예외가 발생한다.") {
            // given
            val input = "1 + a"

            // when then
            val exception = shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(input)
            }
            exception.message shouldBe "연산할 수 없는 문자열 입니다. value: a"
        }

        test("입력값에 지원하지 않는 연산자가 있으면 예외가 발생한다.") {
            // given
            val input = "1 & a"

            // when then
            val exception = shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(input)
            }
            exception.message shouldBe "지원하지 않는 연산자 입니다. operator: &"
        }

        test("1 + 1을 입력하면 2가 된다.") {
            // given
            val input = "1 + 1"

            // when
            val result: String = StringCalculator.calculate(input)

            // then
            result shouldBe "2"
        }

        test("2 - 1을 입력하면 1이 된다.") {
            // given
            val input = "2 - 1"

            // when
            val result: String = StringCalculator.calculate(input)

            // then
            result shouldBe "1"
        }

        test("3 * 2를 입력하면 6이 된다.") {
            // given
            val input = "3 * 2"

            // when
            val result: String = StringCalculator.calculate(input)

            // then
            result shouldBe "6"
        }

        test("10 / 2를 입력하면 5가 된다.") {
            // given
            val input = "10 / 2"

            // when
            val result: String = StringCalculator.calculate(input)

            // then
            result shouldBe "5"
        }

        test("2 + 3 * 4 / 2 - 1 을 입력하면 9가 된다.") {
            // given
            val input = "2 + 3 * 4 / 2 - 1"

            // when
            val result: String = StringCalculator.calculate(input)

            // then
            result shouldBe "9"
        }
    }
})
