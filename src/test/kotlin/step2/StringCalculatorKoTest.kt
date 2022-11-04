package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class StringCalculatorKoTest : StringSpec({
    "2 + 3 * 4 / 2 의 결과는?" {
        StringCalculator.calculate("2 + 3 * 4 / 2") shouldBe 10
    }

    "입력값이 널인 경우" {
        shouldThrow<IllegalArgumentException> { StringCalculator.calculate(null) }
    }

    "입력값이 빈 공백 문자인 경우" {
        shouldThrow<IllegalArgumentException> { StringCalculator.calculate("") }
        shouldThrow<IllegalArgumentException> { StringCalculator.calculate(" ") }
    }
})
