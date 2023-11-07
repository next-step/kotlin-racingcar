package carracing.model.model

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class RacingTest {

    companion object {
        private fun getMockedCar() = mockk<Car>().apply {
            every { move(any()) } returns Unit
        }

        private val alwaysMoveRule = Rule.AlwaysMoveRule()
        private val noMoveRule = Rule.NoMoveRule()
    }

    @Test
    fun `progress - every car move once`() {
        val numberOfCar = 4
        val randomRule = Rule.RandomRule()
        val racing = Racing(numberOfCar, randomRule)
        val racingFieldCars = Racing::class.java.getDeclaredField("cars")
        racingFieldCars.trySetAccessible()
        racingFieldCars.set(racing, List<Car>(4) { getMockedCar() })

        racing.progress()

        racing.cars.forEach {
            verify(exactly = 1) { it.move(randomRule) }
        }
    }

    @Test
    fun `takeSnapshot - create a snapshot object`() {
        val numberOfCar = 4
        val racing = Racing(numberOfCar)

        val snapshot = racing.takeSnapshot()

        assertNotNull(snapshot)
    }
}
