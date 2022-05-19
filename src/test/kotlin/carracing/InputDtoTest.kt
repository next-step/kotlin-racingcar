package carracing

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class InputDtoTest : StringSpec({
    "carNames 는 자동차에 이름을 저장한다" {
        // given
        val carNamesString = "pobi,crong,honux"
        val movementTryCountString = "3"

        // when
        val inputDto = InputDto(carNamesString, movementTryCountString)

        // then
        inputDto.carNames.size shouldBe 3
        inputDto.carNames[0] shouldBe "pobi"
        inputDto.carNames[1] shouldBe "crong"
        inputDto.carNames[2] shouldBe "honux"
    }

    "자동차 이름을 하나도 입력하자 않은면 IllegalArgumentException 발생한다" {
        // given
        val carNamesString = ",  ,,  ,  "
        val movementTryCountString = "3"

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            InputDto(carNamesString, movementTryCountString)
        }

        // then
        exception.message shouldBe "자동차 이름은 공백이 올수 없습니다"
    }

    "자동차 이름을 공백만 입력하면 IllegalArgumentException 발생한다" {
        // given
        val carNamesString = "a,b,c,  ,d"
        val movementTryCountString = "3"

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            InputDto(carNamesString, movementTryCountString)
        }

        // then
        exception.message shouldBe "자동차 이름은 공백이 올수 없습니다"
    }

    "자동차 이름을 5자 초과하면 IllegalArgumentException 발생한다" {
        // given
        val carNamesString = "123456"
        val movementTryCountString = "3"

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> {
            InputDto(carNamesString, movementTryCountString)
        }

        // then
        exception.message shouldBe "자동차 이름은 5글자를 초과할수 없습니다"
    }

    "inputDto 는 data class 이다 " {
        // given
        val carNamesString = "a,b,c,d"
        val movementTryCount = "5"
        val inputDto1 = InputDto(carNamesString, movementTryCount)
        val inputDto2 = InputDto(carNamesString, movementTryCount)

        // then
        inputDto1 shouldBe inputDto2
    }

    "movementTryCount 에 공백이 포함된 값을 입력 받아도 정상 저장 한다" {
        // given
        val carNamesString = "a,b,c,d"
        val movementTryCount = "  5  1  3   2  "

        // when
        val inputDto = InputDto(carNamesString, movementTryCount)

        // then
        inputDto.movementTryCount shouldBe 5132
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
