package car_racing

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InputDtoTest : StringSpec({
    "inputDto 는 자동차 대수, 시도할 횟수를 입력 받아 Int Property 로 저장한다" {
        // given
        val carCount = "3"
        val movementTryCount = "5"

        // when
        val inputDto = InputDto(carCount, movementTryCount)

        // then
        inputDto.carCount shouldBe 3
        inputDto.movementTryCount shouldBe 5
    }

    "inputDto 는 data class 이다 " {
        // given
        val carCount = "3"
        val movementTryCount = "5"
        val inputDto1 = InputDto(carCount, movementTryCount)
        val inputDto2 = InputDto(carCount, movementTryCount)

        // when
        val dtoIsMatch = inputDto1 == inputDto2

        // then
        dtoIsMatch shouldBe true
    }

    "inputDto 는 공백이 포함된 값을 입력 받아도 정상 저장 한다" {
        // given
        val carCount = "  3  0  "
        val movementTryCount = "  5  1  3   2  "

        // when
        val inputDto = InputDto(carCount, movementTryCount)

        // then
        inputDto.carCount shouldBe 30
        inputDto.movementTryCount shouldBe 5132
    }

    "inputDto 는 정수가 아닌 값을 넣으면 IllegalArgumentException 에러가 발생한다" {
        // given
        val carCount = "  test 123 !@#"
        val movementTryCount = "  5  1  3   2  "

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            InputDto(carCount, movementTryCount)
        }

        // then
        exception.message shouldBe ErrorMessage.getErrorMessageForOnlyIntegerString("자동차 대수", carCount)
    }

    "validateForIntegerString 정수를 확인한다." {
        // given
        val integerString = "10"
        val parameterName = "integerString"

        // then
        shouldNotThrow<Error> {
            InputDto.validateForIntegerString(integerString, parameterName)
        }
    }

    "validateForIntegerString 정수가 아닌 값은 IllegalArgumentException 에러가 발생한다" {
        // given
        val integerString = "10test!@"
        val parameterName = "testParameterName"

        // then
        shouldThrow<IllegalArgumentException> {
            InputDto.validateForIntegerString(integerString, parameterName)
        }.message shouldBe ErrorMessage.getErrorMessageForOnlyIntegerString(parameterName, integerString)
    }
})
