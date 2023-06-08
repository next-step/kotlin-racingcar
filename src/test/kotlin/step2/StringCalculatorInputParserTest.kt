package step2

import io.kotest.assertions.throwables.shouldThrow
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringCalculatorInputParserTest {

    private lateinit var parser: StringCalculatorInputParser

    @BeforeEach
    fun setup() {
        parser = StringCalculatorInputParser()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "  ", "null"])
    fun `Invalid input`(testValue: String?) {
        shouldThrow<IllegalArgumentException> {
            val input = if (testValue.equals("null")) null else testValue

            parser.parse(input)
        }
    }

    @Test
    fun `parse 2 + 1`() {
        val input = "2 + 1"

        val result = parser.parse(input)

        Assertions.assertThat(result).hasSize(3)
        Assertions.assertThat(result[0]).isEqualTo("2")
        Assertions.assertThat(result[1]).isEqualTo("+")
        Assertions.assertThat(result[2]).isEqualTo("1")
    }
}
