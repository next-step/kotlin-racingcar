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
}
