import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "      ", "\n", "\t"])
    fun `throw IllegalArgumentException if the input value is blank`(value: String) {
        val calculator = Calculator()

        assertThatThrownBy {
            calculator.compute(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input should not be blank")
    }

    @ParameterizedTest
    @ValueSource(strings = ["8 + invalid - symbols", "(8 + 12)", "^k / 123"])
    fun `throw IllegalArgumentException if the input contains invalid symbols`(value: String) {
        val calculator = Calculator()

        assertThatThrownBy {
            calculator.compute(value)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Input contains invalid symbols")
    }

    @Test
    fun `throw IllegalArgumentException if tokens size of input is less than 3`() {
        val calculator = Calculator()
        val testInput = "2 +"

        assertThatThrownBy {
            calculator.compute(testInput)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Expression is too short to compute")
    }

    @Test
    fun `throw IllegalArgumentException if there is missing operand after operator`() {
        val calculator = Calculator()
        val testInput = "2 + 8 * "

        assertThatThrownBy {
            calculator.compute(testInput)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Missing operand after operator '*'")
    }

    @Test
    fun `compute valid expression`() {
        val calculator = Calculator()
        val expression = "2 + 3 * 4 / 2"

        val result = calculator.compute(expression)

        assertThat(result).isEqualTo(10)
    }
}