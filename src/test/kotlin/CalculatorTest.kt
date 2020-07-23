import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    internal fun addTest() {
        val result = Calculator().calculation("2 + 3 * 4 / 2")
        assertThat(result).isEqualTo(10)
    }
}