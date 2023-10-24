package step2

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
})
