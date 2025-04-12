package carracing.game.domain.data

import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class RaceTest {
    @Test
    fun `when advanceRace should move cars and increment round`() =
        runTest {
            val car1 = mock<Car>()
            val car2 = mock<Car>()
            val cars = listOf(car1, car2)
            val race = Race(cars = cars)

            race.advanceRace()
            race.advanceRace()

            race.round shouldBe 2
            verify(car1, times(2)).move()
            verify(car2, times(2)).move()
        }

    @Test
    fun `when a car has max position, getWinners should return the car`() =
        runTest {
            val car1 = Car.of(position = 1, name = "car", generateMoveNumber = { 1 })
            val car2 = Car.of(position = 2, name = "car2", generateMoveNumber = { 1 })
            val car3 = Car.of(position = 3, name = "car3", generateMoveNumber = { 1 })

            val race = Race(cars = listOf(car1, car2, car3))

            race.winners shouldBe listOf(car3)
        }

    @Test
    fun `when multiple cars have max position, getWinners should return all such cars`() =
        runTest {
            val car1 = Car.of(position = 1, name = "car", generateMoveNumber = { 1 })
            val car2 = Car.of(position = 2, name = "car2", generateMoveNumber = { 1 })
            val car3 = Car.of(position = 2, name = "car3", generateMoveNumber = { 1 })

            val race = Race(cars = listOf(car1, car2, car3))

            race.winners shouldBe listOf(car2, car3)
        }
}
