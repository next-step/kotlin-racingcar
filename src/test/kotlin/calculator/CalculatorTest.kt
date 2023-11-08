package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorTest {
    @Test
    fun `더하기 테스트`() {
        val result = Calculator.calculate("1 + 2")
        assertEquals(3, result)
    }

    @Test
    fun `왼쪽부터 오른쪽 순서대로 연산 테스트`() {
        val result = Calculator.calculate("1 + 2 * 3 - 4 / 2")
        assertEquals(2, result)
    }

    @Test
    fun `expression size 가 3 이하인 경우 throw IllegalArgumentException`() {
        val exception = assertThrows<IllegalArgumentException> {
            Calculator.calculate("1 +")
        }
        assertEquals("잘못된 입력입니다.", exception.message)
    }

    @Test
    fun `사칙연산에 해당하지 않는 경우, operator as NONE and skip`() {
        val result = Calculator.calculate("1 % 2")
        assertEquals(1, result)
    }

    @Test
    fun `invalid number인 경우, skip`() {
        val result = Calculator.calculate("1 + abc")
        assertEquals(1, result)
    }

    @Test
    fun `operator가 없는 경우, skip`() {
        val result = Calculator.calculate("1 2 3")
        assertEquals(1, result)
    }
}
