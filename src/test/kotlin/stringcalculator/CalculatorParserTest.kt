package stringcalculator

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class CalculatorParserTest {
    val calculatorParser = CalculatorParser()

    @Test
    fun `valid expression`() {
        val validExpression = "10 + 9 - 1 / 10 * 1"
        assertThat(calculatorParser.parse(validExpression))
            .containsExactly("10", "+", "9", "-", "1", "/", "10", "*", "1")
    }

    @Test
    fun `should throw exception when input is blank`() {
        listOf("", " ").forEach { blankInput ->
            assertThatThrownBy { calculatorParser.parse(blankInput) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessageContaining("Input is blank")
        }
    }

    @Test
    fun `should throw exception when expression starts with an operator`() {
        assertThatThrownBy { calculatorParser.parse("+ 12 * 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("first symbol must to numeric")
    }

    @Test
    fun `should throw exception when expression ends with an operator`() {
        assertThatThrownBy { calculatorParser.parse("12 + 3 *") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("last symbol must to numeric")
    }

    @Test
    fun `should throw exception when expression contains consecutive operators`() {
        assertThatThrownBy { calculatorParser.parse("12 + * 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("continuous operator must not allow operators")
    }

    @Test
    fun `should throw exception when expression contains consecutive operands`() {
        assertThatThrownBy { calculatorParser.parse("12 34 + 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("continuous operand must not allow operators")
    }

    @Test
    fun `should throw exception when an invalid character is included`() {
        assertThatThrownBy { calculatorParser.parse("12 + a * 3") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("a isn't a arithmetic operator")
    }
}
