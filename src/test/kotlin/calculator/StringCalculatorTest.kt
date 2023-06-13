package calculator

import calculator.exception.IllegalExpressionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    @Test
    fun `기본 예제 테스트`() {
        val expression = "2 + 3 * 4 / 2"
        val result = StringCalculator.calculate(expression)

        assertThat(result).isEqualTo(10F)
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
