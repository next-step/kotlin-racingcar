package calculator.validator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("간단한 식 검증기(SimpleExpressionValidator)")
class SimpleExpressionValidatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 null 또는 빈 공백 문자일 경우 예외가 발생한다`(input: String?) {
        assertThatThrownBy { SimpleExpressionValidator.validated(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc", "1+ 2", "1 + 2 -"])
    fun `입력값이 올바르지 않으면 예외가 발생한다`(input: String) {
        assertThatThrownBy { SimpleExpressionValidator.validated(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}
