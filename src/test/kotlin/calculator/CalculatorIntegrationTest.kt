package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CalculatorIntegrationTest {

    private val calculator = Calculator()

    @Test
    fun `1 + 1 을 계산할 경우 2를 반환해야한다`() {
        assertEquals(calculator.calculate("1 + 1"), 2)
    }

    @Test
    fun `1 - 1 을 계산할 경우 0를 반환해야한다`() {
        assertEquals(calculator.calculate("1 - 1"), 0)
    }

    @Test
    fun `1 * 2 을 계산할 경우 2를 반환해야한다`() {
        assertEquals(calculator.calculate("1 * 2"), 2)
    }

    @Test
    fun `2 ÷ 2 을 계산할 경우 1를 반환해야한다`() {
        assertEquals(calculator.calculate("2 / 2"), 1)
    }

    @Test
    fun `10 * 3 - 6 을 계산할 경우 24를 반환해야한다`() {
        assertEquals(calculator.calculate("10 * 3 - 6"), 24)
    }

    @Test
    fun `5 * 3 ÷ 6 + 10 - 5 를 계산할 경우 7를 반환해야한다`() {
        assertEquals(calculator.calculate("5 * 3 / 6 + 10 - 5"), 7)
    }

    @Test
    fun `1 + 3 * 6 를 계산할 경우 24를 반환해야한다`() {
        assertEquals(calculator.calculate("1 + 3 * 6"), 24)
    }

    @Test
    fun `빈 수식을 입력했을 땐, IllegalArgumentException 에러를 발생시킨다`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("") }
    }

    @Test
    fun `적절치않은 연산자가 들어가면, IllegalArgumentException 에러를 발생시킨다`() {
        assertThrows<IllegalArgumentException> { calculator.calculate("1 ^ 1") }
    }
}
