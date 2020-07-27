package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ExpressionParserTest {

    @Test
    fun parse() {
        assertThat(ExpressionParser.parse("3 + 4 / 2 + 5")).isEqualTo(listOf("3", "+", "4", "/", "2", "+", "5"))
        assertThat(ExpressionParser.parse("-3.5 + 2.2")).isEqualTo(listOf("-3.5", "+", "2.2"))
    }
}
