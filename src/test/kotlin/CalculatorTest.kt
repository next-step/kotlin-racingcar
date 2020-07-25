import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `empty test`() {
        val calculator = Calculator()
        assertThatThrownBy { calculator.calculate(" ") }.isInstanceOf(IllegalArgumentException::class.java)
    }
    @Test
    fun `add test`() {
        val calculator = Calculator()
        val testString = "1 + 2"
        assertThat(calculator.calculate(testString)).isEqualTo(3.0)
    }
    @Test
    fun `minus test`() {
        val calculator = Calculator()
        val testString = "1 - 5"
        assertThat(calculator.calculate(testString)).isEqualTo(-4.0)
    }
    @Test
    fun `times test`() {
        val calculator = Calculator()
        val testString = "6 * 5"
        assertThat(calculator.calculate(testString)).isEqualTo(30.0)
    }
    @Test
    fun `divide test`() {
        val calculator = Calculator()
        val testString = "6 / 5"
        assertThat(calculator.calculate(testString)).isEqualTo(1.2)
    }
    @Test
    fun `total test`() {
        val calculator = Calculator()
        val testString = "2 + 3 * 4 / 2"
        assertThat(calculator.calculate(testString)).isEqualTo(10.0)
    }
}
