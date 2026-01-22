import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun 더하기() {
        val calculator = Calculator();

        val actual = calculator.add(1, 2);

        assertThat(actual).isEqualTo(3)
    }

    @Test
    fun 빼기() {
        val calculator = Calculator();

        val actual = calculator.minus(20, 10);

        assertThat(actual).isEqualTo(10)
    }

    @Test
    fun 곱하기() {
        val calculator = Calculator();

        val actual = calculator.multiply(25, 12);

        assertThat(actual).isEqualTo(300)
    }

    @Test
    fun 나누기() {
        val calculator = Calculator();

        val actual = calculator.divide(300, 12);

        assertThat(actual).isEqualTo(25)
    }
}
