package calculator

import calculator.exceptions.NumberSeparationException
import calculator.exceptions.OperationBetweenNumbersException
import com.google.common.truth.Truth
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `when multiple operations present should apply them sequentially`() {
        val input = "2 + 35 - 2 * 42 / 1"
        val expected = 1470.0

        val actual = Calculator.calculate(input)

        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when input contains two numbers in a row should throw exception`() {
        val input = "2 - 2 3 -"

        assertThrows<NumberSeparationException> { Calculator.calculate(input) }
    }

    @Test
    fun `when input contains two operators in a row should throw exception`() {
        val input = "2 + /"

        assertThrows<OperationBetweenNumbersException> { Calculator.calculate(input) }
    }

    @Test
    fun `when first element is not a number should throw exception`() {
        val input = "+ 2 -"

        assertThrows<OperationBetweenNumbersException> { Calculator.calculate(input) }
    }
}
