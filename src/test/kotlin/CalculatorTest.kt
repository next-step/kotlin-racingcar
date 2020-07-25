import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun happyCase() {
        val expression = "2+3*4/2"
        val result = Calculator.calculateExpression(expression)
        assertThat(result).isEqualTo(10)
    }

    @Test
    fun `사칙 연산 기호가 아닌 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            val expression = "2:3*4/2"
            Calculator.calculateExpression(expression)
        }
    }

    @Test
    fun `식에 공백이 들어간 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            val expression = "2 + 3 * 4 / 2"
            Calculator.calculateExpression(expression)
        }
    }

    @Test
    fun `식이 널인 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculateExpression(null)
        }
    }

    @Test
    fun `0 으로 나눌 경우`() {
        assertThatExceptionOfType(ArithmeticException::class.java).isThrownBy {
            val expression = "2+3*4/0"
            Calculator.calculateExpression(expression)
        }
    }
}
