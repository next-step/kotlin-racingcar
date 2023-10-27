package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringCalculatorKoTest : StringSpec({
    "입력값이 null이거나 빈 공백 문자일 경우 예외 발생" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(null)
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(" ")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("  ")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("\n")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("\t")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("\r")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("\r\n")
        }
    }

    "사칙 연산이 아닌 기호가 포함되었을 경우 예외 발생" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("1 , 2")
        }
    }

    "수식이 완성되지 않았을 경우 예외 발생" {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("1 + 2 -")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("1 +")
        }
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate("1 * - + 2")
        }
    }

    "정상 동작" {
        StringCalculator.calculate("1") shouldBe 1
        StringCalculator.calculate("1 + 2") shouldBe 3
        StringCalculator.calculate("1 - 3") shouldBe -2
        StringCalculator.calculate("2 * 3") shouldBe 6
        StringCalculator.calculate("4 / 2") shouldBe 2
        StringCalculator.calculate("1 + 2 - 3 * 4 / 2") shouldBe 0
    }
})
