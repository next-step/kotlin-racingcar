package calculator

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorTest : StringSpec ({
    "문자열 덧셈이 가능하다." {
        // given
        val input = "1 + 1"

        // when
        val result : String = StringCalculator.calculate(input)

        // then
        result shouldBe "2"
    }
})
