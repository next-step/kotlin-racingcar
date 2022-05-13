package step2

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class StringParserTest {
    val parser = StringParser()

    @Test
    fun `parse`() {
        Assertions.assertThat(parser.parse("2 + 3 * 4 / 2")).isEqualTo(
            listOf("2", "+", "3", "*", "4", "/", "2")
        )

        Assertions.assertThat(parser.parse("2")).isEqualTo(
            listOf("2")
        )

        Assertions.assertThat(parser.parse("+")).isEqualTo(
            listOf("+")
        )
    }
}