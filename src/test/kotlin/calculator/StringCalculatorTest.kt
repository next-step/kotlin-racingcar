package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : FunSpec({
    context("StringCalculator의") {
        context("calculate 함수를 호출하여") {
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
        }
    }
})
