package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `연산자가 하나인 경우의 수식 계산`() {
        assertThat(Calculator.calculate("2 - 2")).isEqualTo(0.0)
        assertThat(Calculator.calculate("2.0 - 2")).isEqualTo(0.0)
        assertThat(Calculator.calculate("2 - 0.2")).isEqualTo(1.8)
        assertThat(Calculator.calculate("2 + 2")).isEqualTo(4.0)
        assertThat(Calculator.calculate("8 / 2")).isEqualTo(4.0)
        assertThat(Calculator.calculate("2 * 3")).isEqualTo(6.0)
        assertThat(Calculator.calculate("2.0 * 3.3")).isEqualTo(6.6)
    }

    @Test
    fun `연산자가 두개 이상인 경우의 수식 계산`() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
        assertThat(Calculator.calculate("2 + 3 - 4 / 2")).isEqualTo(0.5)
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
        assertThat(Calculator.calculate("2 + 2 - 2 * 2 / 2")).isEqualTo(2.0)
        assertThat(Calculator.calculate("1.1 + 3.3 * 4 / 2")).isEqualTo(8.8)
    }

    @Test
    fun `계산중 0으로 나누려고 하는 경우의 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("1 / 0") }
    }

    @Test
    fun `공백이 입력 되었을 경우의 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(" ") }
    }

    @Test
    fun `빈칸이 입력 되었을 경우의 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("") }
    }

    @Test
    fun `잘못된 계산식이 입력 되었을 경우의 예외 발생`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("1 +") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("2 2") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("+") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("+ 1") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("2 & 3 & 4 & 2") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("2.0 + 2..") }
    }
}
