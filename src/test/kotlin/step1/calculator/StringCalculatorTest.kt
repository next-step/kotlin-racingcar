package step1.calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
        assertThat(actual).isEqualTo(3.0)
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
        assertThat(actual).isEqualTo(1.0)
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
        assertThat(actual).isEqualTo(4.0)
    }

    @Test
    @DisplayName("나눗셈 수식을 계산한다.")
    fun calculateDivideExpression() {
        // Given
        val given = "6 / 3"
        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(2.0)
    }

    @Test
    @DisplayName("연산자가 여러개인 표현식을 계산한다.")
    fun calculateCompositeExpression() {
        // Given
        val given = "2 + 3 * 4 / 2"

        val calculator = StringCalculator(given)

        // When
        val actual = calculator.calculate()

        // Then
        assertThat(actual).isEqualTo(10.0)
    }
}
