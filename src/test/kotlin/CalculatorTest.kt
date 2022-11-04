import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {
    @Test
    internal fun calculator() {
        val calculator = Calculator()
        assertThrows<IllegalArgumentException> { calculator.calculate("") }
    }

    @Test
    internal fun calculate() {
        val calculator = Calculator()
        val result = calculator.calculate("1 + 2 + 3")
        assertEquals(result, Number("6"))
    }

    @Test
    internal fun calculate2() {
        val calculator = Calculator()
        val result = calculator.calculate("2 * 3 / 2")
        assertEquals(result, Number("3"))
    }
}
