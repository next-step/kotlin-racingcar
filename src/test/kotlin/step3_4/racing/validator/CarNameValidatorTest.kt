package step3_4.racing.validator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import step3_4.validator.CarNamesDuplicateValidator

class CarNameValidatorTest : StringSpec({
    "중복 요소 판단" {
        val input = listOf("pita", "pita", "poby")
        val expectedMessage = "중복 요소가 존재 합니다"
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            CarNamesDuplicateValidator.checkValidate(input)
        }
    }
})
