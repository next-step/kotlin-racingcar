package calculator

import calculator.exception.DivideByZeroException
import calculator.exception.IllegalExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringCalculatorTest {
    @Test
    fun `기본 예제 테스트`() {
        val expression = "2 + 3 * 4 / 2"
        val result = StringCalculator.calculate(expression)

        assertThat(result).isEqualTo(10F)
    }

    @Test
    fun `기본 덧셈 테스트`() {
        val result = StringCalculator.add(1F, 12F)

        assertThat(result).isEqualTo(13F)
    }

    @ParameterizedTest
    @CsvSource("1F,12F", "12F,1F")
    fun `기본 뺄셈 테스트`(num1: Float, num2: Float) {
        val result1 = StringCalculator.subtract(1F, 12F)
        val result2 = StringCalculator.subtract(12F, 1F)

        assertThat(result1).isEqualTo(-11F)
        assertThat(result2).isEqualTo(11F)
    }

    @ParameterizedTest
    @CsvSource("1F,12F", "1F,0F", "3F,0.5F")
    fun `기본 곱셈 테스트`(num1: Float, num2: Float) {
        val result1 = StringCalculator.multiply(1F, 12F)
        val result2 = StringCalculator.multiply(1F, 0F)
        val result3 = StringCalculator.multiply(3F, 0.5F)

        assertThat(result1).isEqualTo(12F)
        assertThat(result2).isEqualTo(0F)
        assertThat(result3).isEqualTo(1.5F)
    }

    @ParameterizedTest
    @CsvSource("10F,5F", "3F,2F")
    fun `기본 나눗셈 테스트`(num1: Float, num2: Float) {
        val result1 = StringCalculator.divide(10F, 5F)
        val result2 = StringCalculator.divide(3F, 2F)

        assertThat(result1).isEqualTo(2F)
        assertThat(result2).isEqualTo(1.5F)
    }

    @Test
    fun `0으로 나누면 에러가 발생한다`() {
        assertThatExceptionOfType(DivideByZeroException::class.java)
            .isThrownBy { StringCalculator.divide(1F, 0F) }
    }

    @Test
    fun `입력값이 빈 공백 문자열인 경우 에러가 발생한다`() {
        assertThatExceptionOfType(IllegalExpressionException::class.java)
            .isThrownBy { StringCalculator.calculate("   ") }
    }

    @Test
    fun `숫자와 사칙연산 기호외의 문자는 포함될 수 없다`() {
        val invalidExpression = "2 + 3 * 4 ? 2"

        assertThatExceptionOfType(IllegalExpressionException::class.java)
            .isThrownBy { StringCalculator.calculate(invalidExpression) }
    }

    @Test
    fun `숫자는 기호보다 1개 많아야 한다`() {
        val invalidExpression = "2 + 3 * 4 + 2 +"

        assertThatExceptionOfType(IllegalExpressionException::class.java)
            .isThrownBy { StringCalculator.calculate(invalidExpression) }
    }

    @Test
    fun `모든 사칙연산 기호를 포함하는 경우 테스트`() {
        val expression = "2 + 3 * 4 / 2 - 5"
        val result = StringCalculator.calculate(expression)

        assertThat(result).isEqualTo(5F)
    }
}
