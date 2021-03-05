package racing

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `확률 값이 항상 0에서 9 사이 값인지 확인한다`() {
        repeat(100) {
            assertTrue(Probability().getProbability() in 0..9)
        }
    }

    @Test
    fun `4보다 작은 확률 값은 position이 증가하지 않는다`() {
        repeat(100) {
            val car = Car(LowProbabilityProxy())
            car.tryGo()
            assertTrue(car.position == 1)
        }
    }

    @Test
    fun `4보다 큰 확률 값은 position이 증가한다`() {
        repeat(100) {
            val car = Car(HighProbabilityProxy())
            car.tryGo()
            assertTrue(car.position == 2)
        }
    }
}
