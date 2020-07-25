package onestep.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test

class CalculatorInputTest {

    @Test
    fun `Good Case`() {
        assertThat(CalculatorInputManager.calculate("1 + 3")).isEqualTo("4.0")
        assertThat(CalculatorInputManager.calculate("3 + 7 * 5")).isEqualTo("50.0")
        assertThat(CalculatorInputManager.calculate("1 - 3 / 2 * 5")).isEqualTo("-5.0")
        assertThat(CalculatorInputManager.calculate("13 + 32 - 35 * 0 / 3")).isEqualTo("0.0")
    }

    @Test
    fun `Wrong Input`() {
        val input = " "
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }

    @Test
    fun `Wrong Expression Case1 - Blank Miss`() {
        val input = "1 +2 + 4 / 3"
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }

    @Test
    fun `Wrong Expression Case2 - Unknown operator`() {
        val input = "1 % 2 + 4 / 3"
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }

    @Test
    fun `Wrong Expression Case3 - Wrong operator Expression`() {
        val input = "1 ++ 2 + 4 / 3"
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CalculatorInputManager.calculate(input)
        }
    }
}
