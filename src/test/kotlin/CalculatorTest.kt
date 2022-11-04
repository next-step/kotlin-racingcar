import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class CalculatorTest {
    @Test
    internal fun calculator() {
        val calculator = Calculator();
        assertThrows<IllegalArgumentException> { calculator.main("") }
    }
}

