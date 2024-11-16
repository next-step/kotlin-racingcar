package stringCalculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class StringCalculatorKoTest : StringSpec({
    "입력값이 null일 경우 예외를 반환한다. " {
        shouldThrow<IllegalArgumentException> {
            StringCalculator.calculate(null)
        }
    }

    "입력값이 공백 문자일 경우 예외를 반환한다. " {
        assertSoftly {
            shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate("")
            }
            shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate(" ")
            }
        }
    }
    "올바른 식이 아닐경우 예외를 반환한다." {
        assertSoftly {
            shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate("asdsd-a")
            }

            shouldThrow<IllegalArgumentException> {
                StringCalculator.calculate("2 a 1")
            }
        }
    }

    "입력값에 대해 올바른 연산을 할 수 있어야 한다." {
        forAll(
            row("1 + 2", 3),
            row("5 - 2", 3),
            row("5 * 2", 10),
            row("10 / 2", 5),
        ) { param, result -> StringCalculator.calculate(param) shouldBe result }
    }
})
