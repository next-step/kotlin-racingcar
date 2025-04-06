package calculator

import calculator.exceptions.BlankInputException
import calculator.exceptions.EvenNumberElementsException
import calculator.exceptions.InvalidCharacterException
import calculator.exceptions.NotEnoughElementsException
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class InputParserTest {
    @Test
    fun `when input is valid should return list of elements`() {
        val input = "2 + 35 - 2 * 42  / 1"
        val expected = listOf("2", "+", "35", "-", "2", "*", "42", "/", "1")

        val actual = InputParser.validateInput(input)

        actual shouldBe expected
    }

    @Test
    fun `when input is blank should throw BlankInputException`() {
        val input = "    "

        shouldThrowExactly<BlankInputException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input is null should throw BlankInputException`() {
        val input = null

        shouldThrowExactly<BlankInputException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has invalid characters should throw InvalidCharacterException`() {
        val input = "2 ^ 3"

        shouldThrowExactly<InvalidCharacterException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has even number of elements should throw EvenNumberElementsException`() {
        val input = "2 + 3 - "

        shouldThrowExactly<EvenNumberElementsException> { InputParser.validateInput(input) }
    }

    @Test
    fun `when input has less than 3 elements should throw NotEnoughElementsException`() {
        val input = "2"

        shouldThrowExactly<NotEnoughElementsException> { InputParser.validateInput(input) }
    }
}
