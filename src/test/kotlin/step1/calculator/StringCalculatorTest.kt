package step1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("문자열 계산기")
internal class StringCalculatorTest {
    @Test
    @DisplayName("덧셈 수식을 계산한다.")
    fun calculateAddExpression() {
        // Given
        val given = "1 + 2"
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(3)
    }

    @Test
    @DisplayName("뺼셈 수식을 계산한다.")
    fun calculateMinusExpression() {
        // Given
        val given = "2 - 1"
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(1)
    }

    @Test
    @DisplayName("곱셈 수식을 계산 한다.")
    fun calculateMultiplyExpression() {
        // Given
        val given = "2 * 2"
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(4)
    }

    @Test
    @DisplayName("나눗셈 수식을 계산한다.")
    fun calculateDivideExpression() {
        // Given
        val given = "8 / 5"
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(1.6)
    }

    @Test
    @DisplayName("사칙 연산을 모두 포함한 표현식을 계산한다.")
    fun calculateContainsAllArithmeticExpression() {
        // Given
        val given = "1 - 2 + 3 * 4 / 5"

        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(1.6)
    }

    @ParameterizedTest(name = "[Case#{index}]{0} : {1}")
    @MethodSource
    @DisplayName("입력값이 유효하지 않은 경우 경우 예외가 발생한다.")
    fun throwException_WhenInputNullOrEmptyString(description: String, given: String) {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { StringCalculator(given) }
    }

    companion object {
        @JvmStatic
        fun throwException_WhenInputNullOrEmptyString(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("빈값", ""),
                Arguments.of("공백", ""),
                Arguments.of("공백으로 구분되지 않은 경우", "1+1"),
                Arguments.of("계산 항목이 부족한 표현식", " 1 "),
                Arguments.of("계산 항목이 포함되지 않은 표현식", " +++ "),
                Arguments.of("계산 항목이 올바르지 않은 표현식", " 1++ "),
                Arguments.of("계산 항목이 올바르지 않은 표현식", " +1+ "),
            )
        }
    }
}
