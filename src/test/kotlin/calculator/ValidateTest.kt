package calculator

import calculator.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidateTest {
    @Test
    fun isOddTest() {
        assertEquals(true, isOdd(1))
    }

    @Test
    fun isEvenTest() {
        assertEquals(true, isEven(2))
    }

    @Test
    fun isEvenAndDigitTest() {
        assertEquals(true, isEvenAndDigit("2", 2))
    }

    @Test
    fun isOddAndOperatorTest() {
        assertEquals(true, isOddAndOperator("+", 1))
    }

    @Test
    fun isAllDigitsTest() {
        assertEquals(true, isAllDigits("123"))
        assertEquals(false, isAllDigits("13dsdfss23"))
    }

    @Test
    fun isValidOperatorTest() {
        assertEquals(true, isValidOperator("+"))
        assertEquals(false, isValidOperator("123"))
    }

    @Test
    fun validateNullTest() {
        assertThrows<IllegalArgumentException> {
            validateNull(null)
        }
    }
    @Test
    fun validateInputExpressionTest() {
        assertThrows<IllegalArgumentException> {
            validateInputExpression("123 123 123")
        }
    }
}
