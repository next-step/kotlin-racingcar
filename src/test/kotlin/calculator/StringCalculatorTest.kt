package calculator

import calculator.exception.DivideByZeroException
import calculator.exception.IllegalExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
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
    @CsvSource("1F,12F,-11F", "12F,1F,11F")
    fun `기본 뺄셈 테스트`(num1: Float, num2: Float, expect: Float) {
        val result = StringCalculator.subtract(num1, num2)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource("1F,12F,12F", "1F,0F,0F", "3F,0.5F,1.5F")
    fun `기본 곱셈 테스트`(num1: Float, num2: Float, expect: Float) {
        val result = StringCalculator.multiply(num1, num2)

        assertThat(result).isEqualTo(expect)
    }

    @ParameterizedTest
    @CsvSource("10F,5F,2F", "3F,2F,1.5F")
    fun `기본 나눗셈 테스트`(num1: Float, num2: Float, expect: Float) {
        val result = StringCalculator.divide(num1, num2)

        assertThat(result).isEqualTo(expect)
    }

    @Test
    fun `0으로 나누면 에러가 발생한다`() {
        assertThrows<DivideByZeroException> { StringCalculator.divide(1F, 0F) }
    }

    @Test
    fun `입력값이 빈 공백 문자열인 경우 에러가 발생한다`() {
        assertThrows<IllegalExpressionException> { StringCalculator.calculate("   ") }
    }

    @Test
    fun `숫자와 사칙연산 기호외의 문자는 포함될 수 없다`() {
        val invalidExpression = "2 + 3 * 4 ? 2"

        assertThrows<IllegalExpressionException> { StringCalculator.calculate(invalidExpression) }
    }

    @Test
    fun `숫자는 기호보다 1개 많아야 한다`() {
        val invalidExpression = "2 + 3 * 4 + 2 +"

        assertThrows<IllegalExpressionException> { StringCalculator.calculate(invalidExpression) }
    }

    @Test
    fun `모든 사칙연산 기호를 포함하는 경우 테스트`() {
        val expression = "2 + 3 * 4 / 2 - 5"
        val result = StringCalculator.calculate(expression)

        assertThat(result).isEqualTo(5F)
    }
}
