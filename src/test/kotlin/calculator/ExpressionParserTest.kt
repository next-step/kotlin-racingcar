package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource

class ExpressionParserTest {
    @EmptySource
    @ParameterizedTest
    fun `Throw IllegalArgumentException when expression is blank`(input: String) {
        // given && when && then
        assertThrows<IllegalArgumentException> { ExpressionParser(input) }
    }

    @Test
    fun `Does not throw IllegalArgumentException when expression is not blank`() {
        // given && when && then
        assertDoesNotThrow { ExpressionParser("2 + 3") }
    }

    @ParameterizedTest
    @CsvSource(
        "2 + 3, +",
        "3 * 9, *",
        "4 / 1, /",
        "6 - 3, -",
    )
    fun `Return operator`(
        expression: String,
        expected: String,
    ) {
        // given
        val expressionParser = ExpressionParser(expression)

        // when
        val actual = expressionParser.getOperators()

        // then
        assertThat(actual.contains(expected)).isTrue()
    }

    @Test
    fun `Return all operators in expression`() {
        // given
        val expressionParser = ExpressionParser("10 - 7 + 2 * 4 / 2")

        // when
        val actual = expressionParser.getOperators()
        val expected = listOf("-", "+", "*", "/")

        // then
        assertThat(actual).containsAnyElementsOf(expected)
    }

    @Test
    fun `Return all operands in expression`() {
        // given
        val expressionParser = ExpressionParser("10 - 7 + 2 * 4 / 2")

        // when
        val actual = expressionParser.getOperands()
        val expected = listOf(10, 7, 2, 4, 2)

        // then
        assertThat(actual).containsAnyElementsOf(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "2 2 3",
        "3 ! 9",
        "4 ) 1",
        "6 A 3",
    )
    fun `Throw IllegalArgumentException when expression has invalid operator`(expression: String) {
        // given
        val expressionParser = ExpressionParser(expression)

        // when && then
        assertThrows<IllegalArgumentException> { expressionParser.getOperators() }
    }

    @ParameterizedTest
    @CsvSource(
        "A + 3",
        "( - 9",
        "! * 1",
        "6 / #",
        "9 / J",
        "A / #",
    )
    fun `Throw IllegalArgumentException when expression has invalid operand`(expression: String) {
        // given
        val expressionParser = ExpressionParser(expression)

        // when && then
        assertThrows<IllegalArgumentException> { expressionParser.getOperands() }
    }
}
