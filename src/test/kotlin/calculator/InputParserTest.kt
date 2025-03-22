package calculator

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputParserTest {
    @Test
    fun `when input is valid should return list of elements`() {
        val input = "2 + 35 - 2 * 42  / 1"
        val expected = listOf("2", "+", "35", "-", "2", "*", "42", "/", "1")

        val actual = InputParser.validateInput(input)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `when input is blank should throw IllegalArgumentException`() {
        val input = "    "

        assertThrows<IllegalArgumentException>(message = "No input was provided") { InputParser.validateInput(input) }
    }

    @Test
    fun `when input is null should throw IllegalArgumentException`() {
        val input = null

        assertThrows<IllegalArgumentException>(message = "No input was provided") { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has invalid characters should throw IllegalArgumentException`() {
        val input = "2 ^ 3"

        assertThrows<IllegalArgumentException>(message = "Input contains invalid characters") { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has even number of elements should throw IllegalArgumentException`() {
        val input = "2 + 3 - "

        assertThrows<IllegalArgumentException>(message = "There should be an odd number of elements") { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has less than 3 elements should throw IllegalArgumentException`() {
        val input = "2"

        assertThrows<IllegalArgumentException>(message = "There should beat least 2 elements") { InputParser.validateInput(input) }
    }
}
