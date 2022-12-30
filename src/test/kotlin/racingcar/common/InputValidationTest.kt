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

    @ParameterizedTest
    @DisplayName("input에 빈값이 들어오면 에러를 낸다")
    @ValueSource(strings = ["", "  "])
    fun namedCarIsNotAllowedEmpty(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.namedCarValidation(input)
        }.isInstanceOf(ExceptionCode.NotAllowNullOrBlank::class.java)
    }

    @ParameterizedTest
    @DisplayName("input에 , 구분자가 없으면 에러를 낸다")
    @ValueSource(strings = ["1;2;3;4", "123451234", "1234512345"])
    fun namedCarIsNotFindSeparator(input: String) {
        Assertions.assertThatThrownBy {
            inputValidation.namedCarValidation(input)
        }.isInstanceOf(ExceptionCode.NotFindSeparator::class.java)
    }

    @ParameterizedTest
    @DisplayName("input가 , 구분자로 split한다")
    @ValueSource(strings = ["test,test1,test2", "test3,test4,test5"])
    fun namedCarStringToDigit(input: String) {
        Assertions.assertThat(inputValidation.namedCarValidation(input)).isEqualTo(input.split(","))
    }
}
