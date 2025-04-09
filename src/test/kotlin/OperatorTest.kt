import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `from should return correct Operator based on symbol`() {
        assertEquals(Operator.plus, Operator.from("+"))
        assertEquals(Operator.minus, Operator.from("-"))
        assertEquals(Operator.multiply, Operator.from("*"))
        assertEquals(Operator.divide, Operator.from("/"))
        assertNull(Operator.from("%"))
    }

    @Test
    fun `getValidSymbols should return all operator symbols`() {
        val symbols = Operator.getValidSymbols()
        assertTrue(symbols.containsAll(listOf('+', '-', '*', '/')))
        assertEquals(4, symbols.size)
    }

    @Test
    fun `apply should correctly calculate results`() {
        assertEquals(5, Operator.plus.apply(2, 3))
        assertEquals(-1, Operator.minus.apply(2, 3))
        assertEquals(6, Operator.multiply.apply(2, 3))
        assertEquals(2, Operator.divide.apply(6, 3))
    }
}