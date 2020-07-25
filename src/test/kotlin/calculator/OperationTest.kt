package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class OperationTest {

    @Test
    fun testAdd() {
        val add = Operation.of("+")!!
        assertEquals(12.0, add(6.0, 6.0))
    }

    @Test
    fun testSub() {
        val sub = Operation.of("-")!!
        assertEquals(0.0, sub(6.0, 6.0))
    }

    @Test
    fun testMulti() {
        val multi = Operation.of("*")!!
        assertEquals(36.0, multi(6.0, 6.0))
    }

    @Test
    fun testDiv() {
        val div = Operation.of("/")!!
        assertEquals(1.0, div(6.0, 6.0))
        assertEquals(Double.NaN, div(1.0, 0.0))
    }

    @Test
    fun `test undefined operator`() {
        assertNull(Operation.of("5"))
    }
}
