package step3_4.racing.validator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import step3_4.validator.CarNameValidator

class CarNameValidatorTest : StringSpec({
    "이름 5자 초과 에러 테스트" {
        val input = listOf("pobyyy")
        val expectedMessage = "이름을 5자 이상 초과할 수 없어요."

        shouldThrowWithMessage<IllegalArgumentException>(expectedMessage) {
            CarNameValidator.checkValidate(input)
        }
    }
    "공백 제거" {
        val input = listOf("sery", "")
        val expectedMessage = "이름을 제대로 입력해 주세요."
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            CarNameValidator.checkValidate(input)
        }
    }
})
