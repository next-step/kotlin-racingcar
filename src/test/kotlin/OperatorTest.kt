import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OperatorTest {

    @Test
    fun `from should return correct Operator based on symbol`() {
        assertEquals(Operator.plus, Operator.from("+"))
        assertEquals(Operator.minus, Operator.from("-"))
        assertEquals(Operator.multiply, Operator.from("*"))
        assertEquals(Operator.divide, Operator.from("/"))
    }

    @Test
    fun `throw exception when symbol does not exist`() {
        val symbol = "$"

        assertThatThrownBy { Operator.from(symbol) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("Unsupported operator: '$symbol'")
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

    @Test
    fun `throw IllegalArgumentException when divide by zero`() {
        assertThatThrownBy {
            Operator.divide.apply(3, 0)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Cannot divide by zero")
    }
}