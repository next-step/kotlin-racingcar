import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun happyCase() {
        val expression = "2+3*4/2"
        val result = Calculator().calculateExpression(expression)
        assertThat(result).isEqualTo(10)
    }
}
