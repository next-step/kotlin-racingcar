package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ExpressionParserTest {

    @Test
    fun parse() {
        assertEquals(listOf("3", "+", "4", "/", "2", "+", "5"), ExpressionParser.parse("3 + 4 / 2 + 5"))
        assertEquals(listOf("-3.5", "+", "2.2"), ExpressionParser.parse("-3.5 + 2.2"))
    }
}
