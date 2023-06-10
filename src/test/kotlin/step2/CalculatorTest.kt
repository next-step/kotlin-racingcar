package step2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import step2.parser.ExpressionParser
import step2.strategy.CalculatorStrategy
import step2.tokenizer.ExpressionTokenizer
import step2.validator.ExpressionValidator

internal class CalculatorTest {
    @ParameterizedTest
    @CsvSource(
        " 2 + 3 * 4 / 2 , 10",
        "1+2, 3",
        "2 * 2 * 2, 8",
        "10000 - 9999 * 2, 2",
    )
    internal fun 성공(expression: String, expected: String) {
        val sut = Calculator(
            expressionValidator = ExpressionValidator(),
            expressionTokenizer = ExpressionTokenizer(),
            expressionParser = ExpressionParser(),
            calculatorStrategy = CalculatorStrategy()
        )
        val actual = sut.calculate(expression)
        assertThat(actual).isEqualTo(expected)
    }
}
