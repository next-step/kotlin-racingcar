import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun 더하기() {
        val calculator = Calculator();

        val actual = calculator.add(1, 2);

        assertThat(actual).isEqualTo(3)
    }

    fun 더하기를_수행한다() {
        val input = "2 + 3"

        val calculator = Calculator();

        val actual = calculator.calc(input);

        assertThat(actual).isEqualTo(3)
    }

    fun 두자리수_더하기를_수행한다() {
        val input = "14 + 25"

        val calculator = Calculator();

        val actual = calculator.calc(input);

        assertThat(actual).isEqualTo(39)
    }

    fun 여러개의_연산자를_받아서_연산을_수행한다() {
        val input = "14 + 25 + 5"

        val calculator = Calculator();

        val actual = calculator.calc(input);

        assertThat(actual).isEqualTo(44)
    }
}
