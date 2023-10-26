package calculator.app

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class StringCalculatorTest : StringSpec({

    "입력이 null 이면 IllegalArgumentException throw" {
        val calculator = StringCalculator()
        shouldThrow<IllegalArgumentException> {
            calculator.calculate(null)
        }
    }

    "입력이 공백 문자열이면 IllegalArgumentException throw" {
        val calculator = StringCalculator()
        shouldThrow<IllegalArgumentException> {
            calculator.calculate("")
        }
    }
})
