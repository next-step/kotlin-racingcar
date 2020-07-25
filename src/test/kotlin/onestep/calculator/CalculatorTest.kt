package onestep.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun plusTest() {
        assertThat(Calculator.operator(0.0, "+", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(0.0, "+", 3.0)).isEqualTo(3.0)
        assertThat(Calculator.operator(-3.0, "+", 3.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(-3.0, "+", -3.0)).isEqualTo(-6.0)
        assertThat(Calculator.operator(4.0, "+", 6.0)).isEqualTo(10.0)
    }

    @Test
    fun minusTest() {
        assertThat(Calculator.operator(0.0, "-", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(3.0, "-", 3.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(0.0, "-", 3.0)).isEqualTo(-3.0)
        assertThat(Calculator.operator(6.0, "-", 4.0)).isEqualTo(2.0)
    }

    @Test
    fun multpayTest() {
        assertThat(Calculator.operator(0.0, "*", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(3.0, "*", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(3.0, "*", -3.0)).isEqualTo(-9.0)
        assertThat(Calculator.operator(6.0, "*", 4.0)).isEqualTo(24.0)
    }

    @Test
    fun divisionTest() {
        assertThat(Calculator.operator(0.0, "/", 2.0)).isEqualTo(0.0)
        assertThat(Calculator.operator(3.0, "/", 3.0)).isEqualTo(1.0)
        assertThat(Calculator.operator(9.0, "/", -3.0)).isEqualTo(-3.0)
        assertThat(Calculator.operator(25.0, "/", 5.0)).isEqualTo(5.0)
    }

    @Test
    fun divisionFromZeroTest() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.operator(25.0, "/", 0.0)
        }
    }

    @Test
    fun unKnowOperatorTest() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.operator(25.0, "%", 5.0)
        }
    }
}
