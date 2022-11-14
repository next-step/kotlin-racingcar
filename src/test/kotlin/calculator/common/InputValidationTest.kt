package calculator.common

import calculator.enums.ExceptionCode
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidationTest {
    private val inputValidation = InputValidation()

    @Test
    @DisplayName("input에 null값이 들어오면 에러를 낸다")
    fun inputIsNotAllowedNull() {
        Assertions.assertThatThrownBy {
            inputValidation.validate(null)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_ALLOWED_NULL_OR_BLANK.getMessage())
    }

    @ParameterizedTest
    @DisplayName("input에 빈값이 들어오면 에러를 낸다")
    @ValueSource(strings = ["", "  "])
    fun inputIsNotAllowedEmpty(input: String?) {
        Assertions.assertThatThrownBy {
            inputValidation.validate(input)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_ALLOWED_NULL_OR_BLANK.getMessage())
    }

    @Test
    @DisplayName("숫자 위치에 숫자가 아니면 에러를 낸다")
    fun inputIsNotMatchNumeric() {
        Assertions.assertThatThrownBy {
            inputValidation.validate("a +")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())

        Assertions.assertThatThrownBy {
            inputValidation.validate("+ 1")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())

        Assertions.assertThatThrownBy {
            inputValidation.validate("( +")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_NUMERIC.getMessage())
    }

    @Test
    @DisplayName("연산자 위치에 연산자가 아니면 에러를 낸다")
    fun inputIsNotMatchOperator() {

        Assertions.assertThatThrownBy {
            inputValidation.validate("1 )")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())

        Assertions.assertThatThrownBy {
            inputValidation.validate("1 &")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())

        Assertions.assertThatThrownBy {
            inputValidation.validate("1 1 1")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining(ExceptionCode.NOT_MATCHED_OPERATOR.getMessage())
    }
}
