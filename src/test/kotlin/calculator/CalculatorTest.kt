package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest() {
    @ParameterizedTest(name = "add {0} return {1}")
    @CsvSource(
        "98 + 1, 99",
        "30 + 10, 40",
        "8 + 2, 10",
    )
    fun `add test`(
        expression: String,
        expected: Int,
    ) {
        // given
        val expressionParser = ExpressionParser(expression)
        val calculator = Calculator(expressionParser)

        // when
        val actual = calculator.execute()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "subtract {0} return {1}")
    @CsvSource(
        "98 - 1, 97",
        "30 - 10, 20",
        "8 - 2, 6",
    )
    fun `subtract test`(
        expression: String,
        expected: Int,
    ) {
        // given
        val expressionParser = ExpressionParser(expression)
        val calculator = Calculator(expressionParser)

        // when
        val actual = calculator.execute()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "multiply {0} return {1}")
    @CsvSource(
        "98 * 1, 98",
        "30 * 10, 300",
        "8 * 2, 16",
    )
    fun `multiply test`(
        expression: String,
        expected: Int,
    ) {
        // given
        val expressionParser = ExpressionParser(expression)
        val calculator = Calculator(expressionParser)

        // when
        val actual = calculator.execute()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "divide {0} return {1}")
    @CsvSource(
        "98 / 1, 98",
        "30 / 10, 3",
        "8 / 2, 4",
    )
    fun `divide test`(
        expression: String,
        expected: Int,
    ) {
        // given
        val expressionParser = ExpressionParser(expression)
        val calculator = Calculator(expressionParser)

        // when
        val actual = calculator.execute()

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest(name = "{0} return {1}")
    @CsvSource(
        "98 + 2 / 10 - 5, 5",
        "30 * 10 / 300, 1",
        "8 / 2 + 2 * 2 / 6, 2",
    )
    fun `Can calculate two operators`(
        expression: String,
        expected: Int,
    ) {
        // given
        val expressionParser = ExpressionParser(expression)
        val calculator = Calculator(expressionParser)

        // when
        val actual = calculator.execute()

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
