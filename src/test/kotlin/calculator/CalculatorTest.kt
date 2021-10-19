package calculator

import calculator.Calculator.Companion.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1 + 4"])
    fun calculate_add_success(input: String) {
        assertThat(calculate(input)).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 - 1"])
    fun calculate_minus_success(input: String) {
        assertThat(calculate(input)).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 * 3"])
    fun calculate_multiple_success(input: String) {
        assertThat(calculate(input)).isEqualTo(12)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 / 2"])
    fun calculate_divide_success(input: String) {
        assertThat(calculate(input)).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun calculate_formula_success(input: String) {
        assertThat(calculate(input)).isEqualTo(10)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun calculate_formula_isNull_error(input: String?) {
        assertThatThrownBy { calculate(input) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 $ 3"])
    fun calculate_operator_notExist_error() {
        assertThatThrownBy { calculate("4 $ 3") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
