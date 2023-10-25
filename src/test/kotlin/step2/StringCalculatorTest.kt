package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec({

    "문자열 계산기 테스트" {
        // given
        val stringCalculator = StringCalculator()
        val input = "2 + 3 * 4 / 2"

        // when
        val actual = stringCalculator.calculate(input)

        // then
        actual shouldBe 10
    }

    "문자열 계산기 테스트 - 입력값이 null이면 에러가 발생한다." {
        // given
        val stringCalculator = StringCalculator()
        val input = null

        // when & then
        shouldThrow<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    "문자열 계산기 테스트 - 입력값이 공백이면 에러가 발생한다." {
        // given
        val stringCalculator = StringCalculator()
        val input = " "

        // when & then
        shouldThrow<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }

    "문자열 계산기 테스트 - 올바른 사칙연산을 입력하지 않으면 에러가 발생한다." {
        // given
        val stringCalculator = StringCalculator()
        val input = "2 ? 3"

        // when & then
        shouldThrow<IllegalArgumentException> {
            stringCalculator.calculate(input)
        }
    }
})
