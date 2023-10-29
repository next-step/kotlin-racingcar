package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExpressionParserTest {
    @Test
    fun `입력값이 숫자 하나라면 해당 숫자를 반환합니다`() {
        val input: String = "1"

        val expression: Expression = ExpressionParser.parse(input)

        assertThat(expression.calculate()).isEqualTo(1)
    }
}