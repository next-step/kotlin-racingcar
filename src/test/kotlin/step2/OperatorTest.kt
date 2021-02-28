package step2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OperatorTest {

    private val operator = Operator()

    @Test
    fun `더하기`() {
        assertEquals(operator.operate(3, 5, "+"), 8)
        assertEquals(operator.operate(15, 44, "+"), 59)
        assertEquals(operator.operate(18, 42, "+"), 60)
    }

    @Test
    fun `빼기`() {
        assertEquals(operator.operate(3, 5, "-"), -2)
        assertEquals(operator.operate(60, 44, "-"), 16)
        assertEquals(operator.operate(18, 42, "-"), -24)
    }

    @Test
    fun `곱하기`() {
        assertEquals(operator.operate(3, 5, "*"), 15)
        assertEquals(operator.operate(15, 44, "*"), 660)
        assertEquals(operator.operate(18, 42, "*"), 756)
    }

    @Test
    fun `나누기`() {
        assertEquals(operator.operate(3, 5, "/"), 0)
        assertEquals(operator.operate(15, 3, "/"), 5)
        assertEquals(operator.operate(60, 30, "/"), 2)
    }
}
