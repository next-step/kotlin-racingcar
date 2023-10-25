package calculator.unit.view

import calculator.view.InputViewImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class InputViewImplTest {

    @Test
    fun `들어온 값을 원소로 분리한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "1 + 2 * 3 - 4 / 5" })
        val result = inputView.inputFormula()
        assertEquals(listOf("1", "+", "2", "*", "3", "-", "4", "/", "5"), result)
    }

    @Test
    fun `입력값이 없으면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { null })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `입력값이 숫자가 아니면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "1 + 2 * 3 - 4 / a" })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `연산자의 자리에 숫자가 오면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "1 + 2 * 3 - 4 / 5 6" })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `숫자 하나가 오면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "1" })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `연산자 하나가 오면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "+" })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `빈값이 오면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "" })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `공백이 오면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { " " })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }

    @Test
    fun `공백이 포함되어 있으면 오류를 반환한다`() {
        val inputView = InputViewImpl(readlnOrNull = { "1 + 2 * 3 - 4 / 5 " })
        assertThrows(IllegalArgumentException::class.java) {
            inputView.inputFormula()
        }
    }
}
