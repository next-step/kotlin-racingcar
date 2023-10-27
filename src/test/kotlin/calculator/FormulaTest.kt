package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class FormulaTest {

    @Test
    fun `수식을 입력받는다`() {
        val inputFormula = Formula("1 + 2 * 3 - 4 / 5")

        assertEquals(inputFormula.elements, listOf("1", "+", "2", "*", "3", "-", "4", "/", "5"))
    }

    @Test
    fun `수식의 길이가 홀수가 아니면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1 + 2 * 3 - 4 / 5 *")
        }
    }

    @Test
    fun `수식의 숫자의 자리에 수식이 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1 + +")
        }
    }

    @Test
    fun `수식의 연산자의 자리에 수식이 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1 1 +")
        }
    }

    @Test
    fun `수식의 숫자가 아닌 문자가 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1 + a")
        }
    }

    @Test
    fun `수식의 연산자가 아닌 문자가 오면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            Formula("1 a 1")
        }
    }

    @Test
    fun `수식을 계산한다`() {
        val inputFormula = Formula("1 + 2 * 3 - 4 / 5")

        assertEquals(inputFormula.calculateFormula(), 1)
    }
}
