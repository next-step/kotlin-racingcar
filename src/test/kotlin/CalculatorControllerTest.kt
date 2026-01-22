import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorControllerTest {


    @Test
    fun 하나의_연산자를_받아서_연산을_수행한다() {
        val input = "14 + 25"

        val calculator = Calculator();
        val calculatorController = CalculatorController(calculator);

        val actual = calculatorController.calc(input);

        assertThat(actual).isEqualTo(39)
    }

    @Test
    fun 여러개의_연산자를_받아서_연산을_수행한다() {
        val input = "10 + 20 * 5 / 15"

        val calculator = Calculator();
        val calculatorController = CalculatorController(calculator);

        val actual = calculatorController.calc(input);

        assertThat(actual).isEqualTo(10)
    }
}
