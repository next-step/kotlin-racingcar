package calculator

import calculator.Calculator.calculate
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    @ParameterizedTest
    @ValueSource(strings = ["1 + 4"])
    fun `calculate add success`(input: String) {
        assertThat(calculate(input)).isEqualTo(5)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 - 1"])
    fun `calculate minus success`(input: String) {
        assertThat(calculate(input)).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 * 3"])
    fun `calculate multiple success`(input: String) {
        assertThat(calculate(input)).isEqualTo(12)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 / 2"])
    fun `calculate divide success`(input: String) {
        assertThat(calculate(input)).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2"])
    fun `calculate formula success`(input: String) {
        assertThat(calculate(input)).isEqualTo(10)
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `calculate formula isNull error`(input: String?) {
        assertThatThrownBy { calculate(input) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 $ 3"])
    fun `calculate operator notExist error`() {
        assertThatThrownBy { calculate("4 $ 3") }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
