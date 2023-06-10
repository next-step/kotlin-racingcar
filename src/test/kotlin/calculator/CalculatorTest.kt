package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {

    @Test
    fun calculate() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10)
        assertThat(Calculator.calculate("1 + 3 * 2 / 2 * 5 + 3")).isEqualTo(23)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 ++ 3 * 4 / 2", "2 2 + 3 * 4 / 2", "", "  ", "2 / 0"])
    fun calculate_incorrect_input() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Calculator.calculate("2 ++ 3 * 4 / 2")
        }
    }
}
