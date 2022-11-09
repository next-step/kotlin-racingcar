import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class CalculatorTest {
    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(value = ["20, 10", "20.2,10", "-1,5"])
    fun `calculate when add operation`(strValue1: String, strValue2: String) {
        // GIVEN
        val operation = Operator.ADD.symbol

        // WHEN
        val calculateResult = calculator.calculate(strValue1, strValue2, operation)

        // THEN
        val result = strValue1.toBigDecimal().add(strValue2.toBigDecimal()).toString()
        assertThat(calculateResult).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["20,10", "20.2,10", "-1,5", "1,5", "1,4.2"])
    fun `calculate when minus operation`(strValue1: String, strValue2: String) {
        // GIVEN
        val operation = Operator.MINUS.symbol

        // WHEN
        val calculateResult = calculator.calculate(strValue1, strValue2, operation)

        // THEN
        val result = strValue1.toBigDecimal().minus(strValue2.toBigDecimal()).toString()
        assertThat(calculateResult).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["20, 10", "20.2,10", "-1,5"])
    fun `calculate when multiple operation`(strValue1: String, strValue2: String) {
        // GIVEN
        val operation = Operator.MULTIPLE.symbol

        // WHEN
        val calculateResult = calculator.calculate(strValue1, strValue2, operation)

        // THEN
        val result = strValue1.toBigDecimal().multiply(strValue2.toBigDecimal()).toString()
        assertThat(calculateResult).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["20, 10", "20.2,10", "-1,5"])
    fun `calculate when divide operation`(strValue1: String, strValue2: String) {
        // GIVEN
        val operation = Operator.DIVIDE.symbol
        // WHEN
        val calculateResult = calculator.calculate(strValue1, strValue2, operation)

        // THEN
        val result = strValue1.toBigDecimal().divide(strValue2.toBigDecimal()).toString()
        assertThat(calculateResult).isEqualTo(result)
    }

    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `calculate incorrect input should throw IllegalArgumentException`(input: String?) {
        // GIVEN
        val value2 = "20.2"
        val operation = Operator.ADD.symbol

        // THEN
        assertThrows<IllegalArgumentException> {
            calculator.calculate(input, value2, operation)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [ "?", "%"])
    fun `calculate non arithmetic operation should throw IllegalArgumentException`(operation: String) {
        // GIVEN
        val value1 = "10"
        val value2 = "2"

        // THEN
        assertThrows<IllegalArgumentException> {
            calculator.calculate(value1, value2, operation)
        }
    }

    @ParameterizedTest
    @CsvSource(value = [ "2 + 3 * 4 / 2, 10", "1.8 - 0.8 * 5 / 0.5, 10"])
    fun calculateStringInput(input: String, result: String) {
        val calculateResult = calculator.calculateStringInput(input)

        assertThat(calculateResult).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = [ "+ + + +", "1 + 1 + 1 + 1 + 1 +", "/ 2 + 3 * 4 / 2", " 1 1 + 1 + 1", "1 + 1 1 + 1"])
    fun `calculateStringInput throw RuntimeException`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            calculator.calculateStringInput(input)
        }

        assertThat(exception.message).isEqualTo(ErrorMessage.InputError.message)
    }
}
