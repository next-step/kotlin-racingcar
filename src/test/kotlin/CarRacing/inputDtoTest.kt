package CarRacing

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.*

class inputDtoTest: StringSpec({
    "validateForIntegerString 정수를 확인한다." {
        // given
        val integerString = "10"
        val parameterName = "integerString"

        // then
        shouldNotThrow<Error> {
            inputDto.validateForIntegerString(integerString, parameterName)
        }
    }

    "validateForIntegerString 정수가 아닌 값은 IllegalArgumentException 에러가 발생한다" {
        // given
        val integerString = "10test!@"
        val parameterName = "testParameterName"


        // then
        shouldThrow<IllegalArgumentException> {
            inputDto.validateForIntegerString(integerString, parameterName)
        }.message shouldBe ErrorMessage.getErrorMessageForOnlyIntegerString(parameterName, integerString)
    }
})
