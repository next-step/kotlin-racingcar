package study.calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    private val calculator = Calculator()

    @Test
    fun `test addition`() {
        assertThat(calculator.add(2, 3)).isEqualTo(5)
    }

    @Test
    fun `test subtraction`() {
        assertThat(calculator.subtract(2, 3)).isEqualTo(-1)
    }

    @Test
    fun `test multiplication`() {
        assertThat(calculator.multiply(2, 3)).isEqualTo(6)
    }

    @Test
    fun `test division`() {
        assertThat(calculator.divide(4, 2)).isEqualTo(2)
    }

    @Test
    fun `throws IllegalArgumentException for null or blank input`() {
        assertThatThrownBy { calculator.evaluate(null) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Expression cannot be null or blank")

        assertThatThrownBy { calculator.evaluate("") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Expression cannot be null or blank")
    }

    @Test
    fun `throws IllegalArgumentException for invalid operator`() {
        assertThatThrownBy { calculator.evaluate("2 & 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid operator")
    }

    @Test
    fun `evaluates expression with all operators`() {
        assertThat(calculator.evaluate("2 + 3 * 4 / 2")).isEqualTo(10)
    }
}
