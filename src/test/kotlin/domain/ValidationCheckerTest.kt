package domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import java.lang.IllegalArgumentException

internal class ValidationCheckerTest {
    companion object {
        const val ADDITION = "+"
        const val SUBTRACT = "-"
        const val DIVISION = "/"
        const val MULTIPLICATION = "*"
    }

    @Test
    fun `널_공백_예외_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkNullAndBlankValidation(null)
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkNullAndBlankValidation("")
                }
            }
        )
    }

    @Test
    fun `널_예외_테스트`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkNull(null)
        }
    }

    @Test
    fun `공백_예외_테스트`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationChecker().checkBlank("")
        }
    }

    @Test
    fun `유효한_숫자가_아닐_경우_예외_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkValidNumber("A")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkValidNumber("+")
                }
            }
        )
    }

    @Test
    fun `유효한_연산자가_아닐_경우_예외_테스트`() {
        assertAll(
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkValidOperator("A")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkValidOperator("@")
                }
            },
            {
                assertThrows(IllegalArgumentException::class.java) {
                    ValidationChecker().checkValidOperator("100")
                }
            }
        )
    }

    @Test
    fun `연산자_확인_함수_테스트`() {
        assertAll(
            { assertEquals(true, ValidationChecker().isOperator(ADDITION)) },
            { assertEquals(true, ValidationChecker().isOperator(SUBTRACT)) },
            { assertEquals(true, ValidationChecker().isOperator(DIVISION)) },
            { assertEquals(true, ValidationChecker().isOperator(MULTIPLICATION)) },
            { assertEquals(false, ValidationChecker().isOperator("A")) },
            { assertEquals(false, ValidationChecker().isOperator("@")) },
            { assertEquals(false, ValidationChecker().isOperator("100")) }
        )
    }
}
