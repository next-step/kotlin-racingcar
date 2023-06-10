package calculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

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
