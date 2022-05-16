package step2

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringExpressionParserTest {
    fun `정상 파싱 테스트`() {
        val input = "2 + 3 * 2"
        val firstNumber = 2
        val expected = Expression(
            arithmeticOperation = ArithmeticOperation.PLUS,
            number = 3,
            nextExpression = Expression(
                arithmeticOperation = ArithmeticOperation.MULTIPLE,
                number = 2
            )
        )
        val result = StringExpressionParser.parse(input)

        assertThat(result?.execute(firstNumber)).isEqualTo(expected.execute(firstNumber))
    }

    @ParameterizedTest
    @CsvSource("2 + 3 ? 4", "2 +", "2 + 3 * 4 /", "+")
    fun `식 형태 오류`(input: String) {
        Assertions.assertThatThrownBy {
            StringExpressionParser.parse(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
