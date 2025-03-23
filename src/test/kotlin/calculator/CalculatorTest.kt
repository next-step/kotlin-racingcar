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
    fun `when input is valid it returns the input`() {
        val input = "2+3"
        val actual =  Calculator.validateInput(input)
        val expected = "2+3"
        assertEquals(expected,actual)
    }
}