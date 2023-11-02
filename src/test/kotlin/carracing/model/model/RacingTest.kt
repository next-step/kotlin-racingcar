package carracing.model.model

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.RepeatedTest
import kotlin.random.Random

class RacingTest {

    companion object {
        private fun getDummyCar(): Car {
            val car = mockk<Car>()
            every { car.move() } returns Unit
            return car
        }

        private fun getRacingWithDummyCars(cars: List<Car>): Racing {
            val racing = Racing(cars.size)
            val racingFieldCars = racing::class.java.getDeclaredField("cars")
            racingFieldCars.trySetAccessible()
            racingFieldCars.set(racing, cars)
            return racing
        }
    }

    @RepeatedTest(10)
    fun `progress - every car move once`() {
        val numberOfCar = Random.nextInt(1, 10)
        val cars = List<Car>(numberOfCar) { getDummyCar() }
        val racing = getRacingWithDummyCars(cars)

        racing.progress()

        cars.forEach {
            verify(exactly = 1) { it.move() }
        }
    }

    @RepeatedTest(10)
    fun `takeSnapshot - create a snapshot object`() {
        val numberOfCar = Random.nextInt(1, 10)
        val racing = Racing(numberOfCar)

        val snapshot = racing.takeSnapshot()

        assertNotNull(snapshot)
    }
}
