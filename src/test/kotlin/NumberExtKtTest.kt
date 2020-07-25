import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class NumberExtKtTest {

    @Test
    fun isOdd() {
        assertTrue(3.isOdd())
        assertFalse(4.isOdd())
    }

    @Test
    fun isInt() {
        assertTrue(3.0.isInt())
        assertFalse(3.5.isInt())
    }

    @Test
    fun toPrintString() {
        assertEquals("4", 4.0.toPrintString())
        assertEquals("4.792", 4.792.toPrintString())
    }

    @Test
    fun isInvalid() {
        assertFalse(12.0.isInvalid())
        assertTrue((3.0 / 0.0).isInvalid())
    }
}
