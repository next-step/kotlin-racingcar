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
    @ParameterizedTest(name = "Case#[{index}]{0} : {1} = {2}")
    @MethodSource
    @DisplayName("덧셈 수식을 계산한다.")
    fun calculateAddExpression(description: String, given: String, expected: Number) {
        // Given
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Case#[{index}]{0} : {1} = {2}")
    @MethodSource
    @DisplayName("뺼셈 수식을 계산한다.")
    fun calculateMinusExpression(description: String, given: String, expected: Number) {
        // Given
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Case#[{index}]{0} : {1} = {2}")
    @MethodSource
    @DisplayName("곱셈 수식을 계산 한다.")
    fun calculateMultiplyExpression(description: String, given: String, expected: Number) {
        // Given
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Case#[{index}]{0} : {1} = {2}")
    @MethodSource
    @DisplayName("나눗셈 수식을 계산한다.")
    fun calculateDivideExpression(description: String, given: String, expected: Number) {
        // Given
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(expected)
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
        fun calculateAddExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("정수의 덧셈", "1 + 2", 3),
                Arguments.of("음수인 실수가 포함된 덧셈", "-1.2 + 2", 0.8)
            )
        }

        @JvmStatic
        fun calculateMinusExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("정수의 뺼셈", "2 - 1", 1),
                Arguments.of("음수가 포함된 뺄셈", "-2 - -2", 0),
                Arguments.of("음수인 실수가 포함된 뺄셈", "-2.1 - 2", -4.1)
            )
        }

        @JvmStatic
        fun calculateMultiplyExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("정수의 곱셈", "2 * 1", 2),
                Arguments.of("음수의 곱셈", "-2 * -2", 4),
                Arguments.of("음수가 포함된 곱셈", "-2 * 2", -4),
                Arguments.of("음수인 실수가 포함된 뺄셈", "-2.1 * 2", -4.2)
            )
        }

        @JvmStatic
        fun calculateDivideExpression(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("정수의 나눗셈", "2 / 2", 1),
                Arguments.of("음수의 곱셈", "-2 / -2", 1),
                Arguments.of("음수가 포함된 곱셈", "-2 / 2", -1),
                Arguments.of("음수인 실수가 포함된 뺄셈", "-2.1 / 2", -1.05)
            )
        }

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
