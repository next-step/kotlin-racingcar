import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumberTest {
    @Test
    internal fun add() {
<<<<<<< HEAD
        val result = Number("1").add(Number("1"))
        assertEquals(result, Number("2"))
=======
        val result = Number(1).add(Number(1))
        assertEquals(result, Number(2))
>>>>>>> 5dba6bbba517e61d7d0759965a9db9f00fb6206f
    }

    @Test
    internal fun add2() {
<<<<<<< HEAD
        val result = Number("1").add(Number("2")).add(Number("3"))
        assertEquals(result, Number("6"))
=======
        val result = Number(1).add(Number(2)).add(Number(3))
        assertEquals(result, Number(1+2+3))
>>>>>>> 5dba6bbba517e61d7d0759965a9db9f00fb6206f
    }
}