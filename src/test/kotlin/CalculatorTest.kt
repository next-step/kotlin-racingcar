import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun 더하기() {
        val calculator = Calculator();

        val actual = calculator.add(1, 2);

        assertThat(actual).isEqualTo(3)
    }

    fun 계산기에서_더하기를_수행할_수_있다() {
        val input = "2 + 3"

        val calculator = Calculator();

        val actual = calculator.calc(input);

        assertThat(actual).isEqualTo(3)
    }

    fun 계산기에서_두자리수_계산을_수행할_수_있다() {
        val input = "14 + 25"

        val calculator = Calculator();

        val actual = calculator.calc(input);

        assertThat(actual).isEqualTo(39)
    }
}
