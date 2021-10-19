package calculator

import calculator.Calculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun calculate_add_success() {
        assertThat(calculate("1 + 4")).isEqualTo(5)
    }

    @Test
    fun calculate_minus_success() {
        assertThat(calculate("4 - 1")).isEqualTo(3)
    }

    @Test
    fun calculate_multiple_success() {
        assertThat(calculate("4 * 3")).isEqualTo(12)
    }

    @Test
    fun calculate_divide_success() {
        assertThat(calculate("4 / 2")).isEqualTo(2)
    }

    @Test
    fun calculate_formula_success() {
        assertThat(calculate("2 + 3 * 4 / 2")).isEqualTo(10)
    }

    @Test
    fun calculate_formula_isNull_error() {
        assertThatThrownBy { calculate(null) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun calculate_operator_notExist_error() {
        assertThatThrownBy { calculate("4 $ 3") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
