package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class ValidatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = ["", "  "])
    fun `입력값이 null이거나 빈 공백 문자이면 오류가 발생한다`(input: String?) {
        // given
        val validator = Validator()

        // when
        val thrown = catchThrowable { validator.validate(input) }

        // then
        assertThat(thrown).isInstanceOf(IllegalArgumentException::class.java)
    }
}
