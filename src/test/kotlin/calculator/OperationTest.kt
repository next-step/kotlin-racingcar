package calculator

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

internal class OperationTest {

    @Test
    fun add() {
        val add = Operation.of("+")!!
        assertEquals(12.0, add(6.0, 6.0))
    }

    @Test
    fun sub() {
        val sub = Operation.of("-")!!
        assertEquals(0.0, sub(6.0, 6.0))
    }

    @Test
    fun multi() {
        val multi = Operation.of("*")!!
        assertEquals(36.0, multi(6.0, 6.0))
    }

    @Test
    fun div() {
        val div = Operation.of("/")!!
        assertEquals(1.0, div(6.0, 6.0))
        assertEquals(Double.NaN, div(1.0, 0.0))
    }

    @Test
    fun `undefined operator`() {
        assertNull(Operation.of("5"))
    }
}
