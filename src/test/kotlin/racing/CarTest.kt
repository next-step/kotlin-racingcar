package racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `확률 값이 항상 0에서 9 사이 값인지 확인한다`() {
        val car = Car()
        val method = car::class.java.getDeclaredMethod("getProbability")
        method.isAccessible = true
        repeat(100) {
            val probability = method.invoke(car) as Int
            assertTrue(probability in 0..9)
        }
    }
}
