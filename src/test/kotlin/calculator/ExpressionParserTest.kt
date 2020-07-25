package calculator

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ExpressionParserTest {

    @Test
    fun parse() {
        assertEquals(listOf("3", "+", "4", "/", "2", "+", "5"), ExpressionParser.parse("3 + 4 / 2 + 5"))
        assertEquals(listOf("34", "+", "23", "-", "1"), ExpressionParser.parse("34+23-1"))
    }

    @Test
    fun parseInvalidExpression() {
        assertThatIllegalArgumentException().isThrownBy { ExpressionParser.parse("3 + 4 + a") }
    }
}
