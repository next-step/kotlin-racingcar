import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {

    private val calculator = Calculator()

    @Test
    fun checkCalculation() {
        assertThat(calculator.add("1", "3")).isEqualTo("4")
        assertThat(calculator.subtract("1", "3")).isEqualTo("-2")
        assertThat(calculator.multiply("1", "3")).isEqualTo("3")
        assertThat(calculator.divide("4", "2")).isEqualTo("2")
    }

    @Test
    fun checkValidation() {
        assertThat(calculator.checkValidation("2 + 3 * 4 / 2")).isEqualTo(InputValidation.SUCCESS)
        assertThat(calculator.checkValidation("")).isEqualTo(InputValidation.EMPTY_STRING)
        assertThat(calculator.checkValidation(null)).isEqualTo(InputValidation.EMPTY_STRING)
        assertThat(calculator.checkValidation("2+ 3 * 4/2")).isEqualTo(InputValidation.BLANK_ERROR)
        assertThat(calculator.checkValidation("2 + 3 * 4 / 2 ")).isEqualTo(InputValidation.BLANK_ERROR)
        assertThat(calculator.checkValidation("2  2")).isEqualTo(InputValidation.BLANK_ERROR)
        assertThat(calculator.checkValidation("2 / 0")).isEqualTo(InputValidation.ZERO_AFTER_DIVIDE)
        assertThat(calculator.checkValidation("2 1 3 * 4 / 2")).isEqualTo(InputValidation.INVALID_NUMBER_SYMBOL_ORDER)
    }

    @Test
    fun checkResult() {
        assertThat(calculator.calculate("1 + 3")).isEqualTo("4")
        assertThat(calculator.calculate("2 + 3 * 4 / 2")).isEqualTo("10")
    }
}
