package domain

import constant.Constants.Companion.ADDITION
import constant.Constants.Companion.DIVISION
import constant.Constants.Companion.MULTIPLICATION
import constant.Constants.Companion.SUBTRACT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class ValidationCheckerTest {

    @Test
    fun checkNullAndBlankValidation() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkNullAndBlankValidation(null)
        }
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkNullAndBlankValidation("")
        }
    }

    @Test
    fun checkNull() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkNull(null)
        }
    }

    @Test
    fun checkBlank() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkBlank("")
        }
    }

    @Test
    fun checkValidNumber() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkValidNumber("A")
        }

        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkValidNumber("+")
        }
    }

    @Test
    fun checkValidOperator() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkValidOperator("A")
        }

        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkValidOperator("@")
        }

        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkValidOperator("100")
        }
    }

    @Test
    fun isOperator() {
        assertEquals(true, ValidationChecker().isOperator(ADDITION))
        assertEquals(true, ValidationChecker().isOperator(SUBTRACT))
        assertEquals(true, ValidationChecker().isOperator(DIVISION))
        assertEquals(true, ValidationChecker().isOperator(MULTIPLICATION))
        assertEquals(false, ValidationChecker().isOperator("A"))
        assertEquals(false, ValidationChecker().isOperator("@"))
        assertEquals(false, ValidationChecker().isOperator("100"))
    }
}
