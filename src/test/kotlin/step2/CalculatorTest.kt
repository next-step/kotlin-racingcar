package step2

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun `단순 계산 테스트`() {
        assertThat(Calculator.calculate("2 - 2")).isEqualTo(0.0)
        assertThat(Calculator.calculate("2.0 - 2")).isEqualTo(0.0)
        assertThat(Calculator.calculate("2 - 0.2")).isEqualTo(1.8)
        assertThat(Calculator.calculate("2 + 2")).isEqualTo(4.0)
        assertThat(Calculator.calculate("8 / 2")).isEqualTo(4.0)
        assertThat(Calculator.calculate("2 * 3")).isEqualTo(6.0)
        assertThat(Calculator.calculate("2.0 * 3.3")).isEqualTo(6.6)
    }

    @Test
    fun `복수 계산 테스트`() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
        assertThat(Calculator.calculate("2 + 3 - 4 / 2")).isEqualTo(0.5)
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10.0)
        assertThat(Calculator.calculate("2 + 2 - 2 * 2 / 2")).isEqualTo(2.0)
        assertThat(Calculator.calculate("1.1 + 3.3 * 4 / 2")).isEqualTo(8.8)
    }

    @Test
    fun `예외 발생 0으로 나눔`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("1 / 0") }
    }
    @Test
    fun `예외 발생 빈칸, 공백`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate(" ") }
    }

    @Test
    fun `예외 발생 잘못된 입력`() {
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("1 +") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("2 2") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("+") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("+ 1") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("2 & 3 & 4 & 2") }
        assertThatIllegalArgumentException().isThrownBy { Calculator.calculate("2.0 + 2..") }
    }
}
