package step3_4.racing.validator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import step3_4.racing.Car
import step3_4.validator.CarNamesDuplicateValidator

class CarNameValidatorTest : StringSpec({
    "이름 5자 초과 에러 테스트" {
        val expectedMessage = "이름을 5자 이상 초과할 수 없어요."

        shouldThrowWithMessage<IllegalArgumentException>(expectedMessage) {
            Car("pitapat")
        }
    }
    "공백 제거" {
        val expectedMessage = "이름을 제대로 입력해 주세요."
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            Car("")
        }
    }
    "중복 요소 판단" {
        val input = listOf("pita", "pita", "poby")
        val expectedMessage = "중복 요소가 존재 합니다"
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            CarNamesDuplicateValidator.checkValidate(input)
        }
    }
})
