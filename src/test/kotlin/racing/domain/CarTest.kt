package racing.domain

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racing.HighProbabilityProxy
import racing.LowProbabilityProxy

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
            val car = Car(CAR_NAME, LowProbabilityProxy())
            car.tryGo()
            assertTrue(car.position == 1)
        }
    }

    @Test
    fun `4보다 작은 확률 값은 record 기록이 증가하지 않는다`() {
        val car = Car(CAR_NAME, LowProbabilityProxy())
        repeat(100) {
            car.tryGo()
        }
        val records = car.getRecords()
        repeat(100) {
            assertTrue(records[it] == 1)
        }
    }

    @Test
    fun `4보다 큰 확률 값은 position이 증가한다`() {
        repeat(100) {
            val car = Car(CAR_NAME, HighProbabilityProxy())
            car.tryGo()
            assertTrue(car.position == 2)
        }
    }

    @Test
    fun `4보다 큰 확률 값은 record 기록이 증가한다`() {
        val car = Car(CAR_NAME, HighProbabilityProxy())
        repeat(100) {
            car.tryGo()
        }
        val records = car.getRecords()
        repeat(100) {
            assertTrue(records[it] == it + 2)
        }
    }

    companion object {
        const val CAR_NAME = "Tesla"
    }
}
