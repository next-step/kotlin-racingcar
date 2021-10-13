package calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource

class ExpressionTest {

    @DisplayName("올바른 식 입력 시 총 숫자와 연산자 개수 리턴")
    @ParameterizedTest
    @CsvSource(value = ["2 + 3 * 4 / 2:7", "1 + 2 * 6:5"], delimiter = ':')
    fun `sut returns correctly`(expression: String, expected: String) {
        // Arrange
        val sut = Expression(expression)

        // Act
        val expressions = sut.segregateExpressions()

        // Assert
        assertThat(expressions).hasSize(expected.toInt())
    }

    @DisplayName("null 혹은 빈값 입력")
    @ParameterizedTest
    @NullAndEmptySource
    fun `sut throw IllegalArgumentException when input is null and empty`(input: String?) {
        // Assert
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Expression(input) }
            .withMessage("입력값은 null 혹은 공백이 올 수 없습니다.")
    }
}
