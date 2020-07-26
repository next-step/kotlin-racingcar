package onestep.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class CalculatorTest {

    @Test
    fun `연산자가 +일 경우, 양수,0,음수의 경우에도, 정상 값이 나와야한다`() {
        assertThat(Calculator.calculate(0.0, "+", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(0.0, "+", 3.0)).isEqualTo(3.0)
        assertThat(Calculator.calculate(-3.0, "+", 3.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(-3.0, "+", -3.0)).isEqualTo(-6.0)
        assertThat(Calculator.calculate(4.0, "+", 6.0)).isEqualTo(10.0)
    }

    @Test
    fun `연산자가 -일 경우, 양수,0,음수의 경우에도, 정상 값이 나와야한다`() {
        assertThat(Calculator.calculate(0.0, "-", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(3.0, "-", 3.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(0.0, "-", 3.0)).isEqualTo(-3.0)
        assertThat(Calculator.calculate(6.0, "-", 4.0)).isEqualTo(2.0)
    }

    @Test
    fun `연산자가 *일 경우, 양수,0,음수의 경우에도, 정상 값이 나와야한다`() {
        assertThat(Calculator.calculate(0.0, "*", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(3.0, "*", 0.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(3.0, "*", -3.0)).isEqualTo(-9.0)
        assertThat(Calculator.calculate(6.0, "*", 4.0)).isEqualTo(24.0)
    }

    @Test
    fun `연산자가 Division일 경우, 양수,음수의 경우에도, 정상 값이 나와야한다`() {
        assertThat(Calculator.calculate(0.0, "/", 2.0)).isEqualTo(0.0)
        assertThat(Calculator.calculate(3.0, "/", 3.0)).isEqualTo(1.0)
        assertThat(Calculator.calculate(9.0, "/", -3.0)).isEqualTo(-3.0)
        assertThat(Calculator.calculate(25.0, "/", 5.0)).isEqualTo(5.0)
    }

    @Test
    fun `연산자가 Division일 경우, 나누는 값이 0이면, Exception을 던져한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.calculate(25.0, "/", 0.0)
        }
    }

    @Test
    fun `연산자가 알수 없는 경우, Exception을 던져한다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            Calculator.calculate(25.0, "%", 5.0)
        }
    }
}
