package calculator

import calculator.exceptions.BlankInputException
import calculator.exceptions.EvenNumberElementsException
import calculator.exceptions.InvalidCharacterException
import calculator.exceptions.NotEnoughElementsException
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
    fun `when input is blank should throw BlankInputException`() {
        val input = "    "

        assertThrows<BlankInputException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input is null should throw BlankInputException`() {
        val input = null

        assertThrows<BlankInputException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has invalid characters should throw InvalidCharacterException`() {
        val input = "2 ^ 3"

        assertThrows<InvalidCharacterException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has even number of elements should throw EvenNumberElementsException`() {
        val input = "2 + 3 - "

        assertThrows<EvenNumberElementsException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has less than 3 elements should throw NotEnoughElementsException`() {
        val input = "2"

        assertThrows<NotEnoughElementsException> { InputParser.validateInput(input) }
    }
}
