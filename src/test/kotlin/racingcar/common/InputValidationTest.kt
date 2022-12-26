package racingcar.common

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InputValidationTest {
    private val inputValidation = InputValidation()

    @DisplayName("input에 null값이 들어오면 에러를 낸다")
    @ParameterizedTest
    @NullAndEmptySource
    fun inputIsNotAllowedNull(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.validate(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("input에 빈값이 들어오면 에러를 낸다")
    @ValueSource(strings = ["", "  "])
    fun inputIsNotAllowedEmpty(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.validate(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("input이 숫자가 아니면 에러를 낸다")
    @ValueSource(strings = ["test", "!123", "zz1+"])
    fun inputIsNotMatchNumeric(input: String) {
        Assertions.assertThatThrownBy {
            inputValidation.validate(input)
        }.isInstanceOf(ExceptionCode.NotMatchNumeric::class.java)
    }

    @ParameterizedTest
    @DisplayName("input에 숫자 string가 들어오면 int로 바꿔준다")
    @ValueSource(strings = ["123", "11", "33"])
    fun inputIsDigit(input: String) {
        Assertions.assertThat(inputValidation.validate(input)).isEqualTo(input.toInt())
    }
}
