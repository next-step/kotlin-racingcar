@file:Suppress("NonAsciiCharacters")

package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorInputValidatorTest {
    private val sut = CalculatorInputValidator()

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = ["", " "])
    fun `validate - 입력값이 null이거나 빈 공백 문자열일 경우 IllegalArgumentException을 던진다`(input: String?) {
        val result = catchThrowable {
            sut.validate(input)
        }

        assertThat(result).isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input should not be null or blank.")
    }
}
