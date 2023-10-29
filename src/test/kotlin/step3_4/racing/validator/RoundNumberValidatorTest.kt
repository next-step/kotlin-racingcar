package step3_4.racing.validator

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import step3_4_5.validator.RoundNumberValidator

class RoundNumberValidatorTest : StringSpec({
    "숫자가 아닌 값을 입력하면 에러가 발생한다" {
        // given
        val input = "asd"
        val expectedMessage = "유효한 값이 입력되지 않았습니다"
        // when
        // then
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            RoundNumberValidator.checkValidate(input)
        }
    }
    "공백을 입력하면 에러가 발생한다" {
        // given
        val input = ""
        val expectedMessage = "값이 입력되지 않았습니다"
        // when
        // then
        shouldThrowWithMessage<IllegalArgumentException>(expectedMessage) {
            RoundNumberValidator.checkValidate(input)
        }
    }
    "null을 입력하면 에러가 발생한다" {
        // given
        val input = null
        val expectedMessage = "값이 입력되지 않았습니다"
        // when
        // then
        shouldThrowWithMessage<IllegalArgumentException>(expectedMessage) {
            RoundNumberValidator.checkValidate(input ?: "")
        }
    }
    "음수를 입력하면 에러가 발생한다" {
        // given
        val input = "-3"
        val expectedMessage = "1 이상의 값을 입력해주세요"
        // when
        // then
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            RoundNumberValidator.checkValidate(input)
        }
    }
    "Double값을 입력하면 에러가 발생한다" {
        // given
        val input = "3.3"
        val expectedMessage = "유효한 값이 입력되지 않았습니다"
        // when
        // then
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            RoundNumberValidator.checkValidate(input)
        }
    }
    "자동차 대수 또는 회차를 0으로 입력한 경우 에러가 발생한다" {
        // given
        val input = "0"
        val expectedMessage = "1 이상의 값을 입력해주세요"
        // when
        // then
        shouldThrowWithMessage<IllegalStateException>(expectedMessage) {
            RoundNumberValidator.checkValidate(input)
        }
    }
})
