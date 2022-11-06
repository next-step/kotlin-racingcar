import calcualator.Calculator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CalculatorApplicationTest {
    @Test
    internal fun `빈 문자열을 입력하면 에러가 남`() {
        val calculatorApplication = CalculatorApplication()
        assertThrows<IllegalArgumentException> { calculatorApplication.calculate("") }
    }

    @Test
    internal fun `공백을 입력하면 에러가 남`() {
        val calculatorApplication = CalculatorApplication()
        assertThrows<IllegalArgumentException> { calculatorApplication.calculate(" ") }
    }

    @ParameterizedTest
    @CsvSource(value = ["1 + 2 + 3:6", "2 * 3 / 2:3"], delimiter = ':')
    internal fun `계산식 확인`(context: String, value: String) {
        val calculatorApplication = CalculatorApplication()
        val result = calculatorApplication.calculate(context)
        assertEquals(result, Calculator(value))
    }
}
