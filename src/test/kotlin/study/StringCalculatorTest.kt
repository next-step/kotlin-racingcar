package study

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringCalculatorTest {
    @Test
    fun `덧셈`() {
        assert(calculate("12 + 4") == 16)
    }

    @Test
    fun `뺄셈`() {
        assert(calculate("12 - 14") == -2)
    }

    @Test
    fun `곱셈`() {
        assert(calculate("11 * 11") == 121)
    }

    @Test
    fun `나눗셈`() {
        assert(calculate("12 / 6") == 2)
    }

    @Test
    fun `복합 연산 테스트`() {
        assert(calculate("12 + 6 / 2 * 10 - 4") == 86)
    }

    @Test
    fun `공백 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculate("")
        }
        assert(exception.message == "input이 null이거나 공백입니다.")
    }

    @Test
    fun `Blank 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculate("     ")
        }
        assert(exception.message == "input이 null이거나 공백입니다.")
    }

    @Test
    fun `null 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculate(null)
        }
        assert(exception.message == "input이 null이거나 공백입니다.")
    }

    @Test
    fun `잘못된 수식 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculate("123 * + 44")
        }
        assert(exception.message == "숫자가 아닌 값이 숫자자리에 입력되었습니다.")
    }

    @Test
    fun `숫자가 하나만 입력됨`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculate("123 *")
        }
        assert(exception.message == "하나 이상의 숫자가 입력되어야합니다.")
    }

    @Test
    fun `사칙연산이 아닌 경우 테스트`() {
        val exception = assertThrows<IllegalArgumentException> {
            calculate("123 & 44")
        }
        assert(exception.message == "사칙연산 기호가 아닙니다.")
    }
}