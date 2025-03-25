package calculator

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CalculatorTest {

    @Test
    fun `when input is blank should throw exception with appropriate message`() {
        val input = "  "
        val exception = assertFailsWith<IllegalArgumentException> {
            Calculator.validateInput(input)
        }
        assertEquals("Input is null or blank", exception.message)
    }

    @Test
    fun `when input is null should throw exception with appropriate message`() {
        val input = null
        val exception = assertFailsWith<IllegalArgumentException> {
            Calculator.validateInput(input)
        }
        assertEquals("Input is null or blank", exception.message)
    }

    @Test
    fun `when input has invalid characters throw exception with appropriate message`() {
        val input = "2 $ 3 "
        val exception = assertFailsWith<IllegalArgumentException> {
            Calculator.validateInput(input)
        }
        assertEquals("Input has invalid characters", exception.message)
    }

    @Test
    fun `when input is valid compute returns the correct value`() {
        val input = "2 * 3"
        val expected = 6
        val actual = Calculator.compute(input)

        assertEquals(expected, actual)
    }

    @Test
    fun `when input has multiple operations compute sequentially`() {
        val input = "2 + 3 * 4 / 2"
        val expected = 10
        val actual = Calculator.compute(input)

        assertEquals(expected, actual)
    }
}
