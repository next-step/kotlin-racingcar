package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun add() {
        assertThat(Calculator.add(10, 0)).isEqualTo(10)
        assertThat(Calculator.add(2, -3)).isEqualTo(-1)
        assertThat(Calculator.add(-5, -2)).isEqualTo(-7)
    }

    @Test
    fun subtract() {
        assertThat(Calculator.subtract(10, 0)).isEqualTo(10)
        assertThat(Calculator.subtract(2, -3)).isEqualTo(5)
        assertThat(Calculator.subtract(-5, -2)).isEqualTo(-3)
    }

    @Test
    fun multiply() {
        assertThat(Calculator.multiply(10, 0)).isEqualTo(0)
        assertThat(Calculator.multiply(2, -3)).isEqualTo(-6)
        assertThat(Calculator.multiply(-5, -2)).isEqualTo(10)
    }

    @Test
    fun divide() {
        assertThat(Calculator.divide(10, 2)).isEqualTo(5)
        assertThat(Calculator.divide(2, -3)).isEqualTo(0)
        assertThat(Calculator.divide(3, 2)).isEqualTo(1)
    }

    fun divide_by_zero() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.divide(3, 0)
        }
    }

    @Test
    fun calculate() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @Test
    fun calculate_incorrect_input() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculate("2 ++ 3 * 4 / 2")
        }
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculate("2 2 + 3 * 4 / 2")
        }

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculate("")
        }

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculate("   ")
        }

        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculate("2 / 0")
        }
    }
}
