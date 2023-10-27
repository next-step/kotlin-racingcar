package calculator

import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class ValidationFormulaTest {
    @Test
    fun `수식의 길이가 홀수가 아니면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationFormula.validateFormula(listOf("+", "2", "*", "3", "-", "4", "/", "5"))
        }
    }

    @Test
    fun `수식의 숫자의 자리에 수식이 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationFormula.validateFormula(listOf("1", "+", "*", "3", "-", "4", "/", "5"))
        }
    }

    @Test
    fun `수식의 연산자의 자리에 수식이 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationFormula.validateFormula(listOf("1", "+", "2", "3", "-", "4", "/", "5"))
        }
    }

    @Test
    fun `수식의 숫자가 아닌 문자가 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationFormula.validateFormula(listOf("1", "+", "2", "a", "-", "4", "/", "5"))
        }
    }

    @Test
    fun `수식의 연산자가 아닌 문자가 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            ValidationFormula.validateFormula(listOf("1", "+", "2", "*", "3", "-", "4", "a", "5"))
        }
    }
}
