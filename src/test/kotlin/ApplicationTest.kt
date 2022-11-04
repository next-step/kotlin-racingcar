import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class ApplicationTest {
    @Test
    internal fun calculator() {
        val application = Application()
        assertThrows<IllegalArgumentException> { application.calculate("") }
    }

    @Test
    internal fun calculate() {
        val application = Application()
        val result = application.calculate("1 + 2 + 3")
        assertEquals(result, Calculator("6"))
    }

    @Test
    internal fun calculate2() {
        val application = Application()
        val result = application.calculate("2 * 3 / 2")
        assertEquals(result, Calculator("3"))
    }
}
