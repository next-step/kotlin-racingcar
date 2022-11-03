import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumberTest {
    @Test
    internal fun add() {
        val result = Number(1).add(Number(1))
        assertEquals(result, Number(2))
    }
}