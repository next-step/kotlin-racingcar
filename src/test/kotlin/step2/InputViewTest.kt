package step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class InputViewTest : FreeSpec({
    "validateInput" - {
        "입력이 null인 경우 IllegalArgumentException" {
            val exception = shouldThrow<IllegalArgumentException> {
                validateInput(null)
            }
            exception.message shouldBe ErrorMessage.INCORRECT_INPUT
        }

        "입력이 빈 문자열인 경우 IllegalArgumentException" {
            val exception = shouldThrow<IllegalArgumentException> {
                validateInput("")
            }
            exception.message shouldBe ErrorMessage.INCORRECT_INPUT
        }

        "입력이 공백으로만 이루어진 경우 IllegalArgumentException" {
            val exception = shouldThrow<IllegalArgumentException> {
                validateInput("    ")
            }
            exception.message shouldBe ErrorMessage.INCORRECT_INPUT
        }
    }
})
