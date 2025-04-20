@file:Suppress("ktlint:standard:no-wildcard-imports")

package carracing.game.domain.data

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.mockito.kotlin.*

class RaceTest {
    private val carsFactory = mock<CarsFactory>()
    private lateinit var race: Race

    private fun init(cars: List<Car>) {
        whenever(carsFactory.from(any())).thenReturn(cars)
        race =
            Race(
                carsNames = emptyList(),
                carsFactory = carsFactory,
                totalRounds = 3,
            )
    }

    @Test
    fun `when advanceRace should move cars and increment round`() {
        val car1 = mock<Car>()
        val car2 = mock<Car>()
        val cars = listOf(car1, car2)
        init(cars = cars)

        race.generateRaceSequence().toList()

        race.round shouldBe 3
        verify(car1, times(3)).move()
        verify(car2, times(3)).move()
    }

    @Test
    fun `when a car has max position, getWinners should return the car`() {
        val car1 = Car(position = 1, name = "car", generateMoveNumber = { 1 })
        val car2 = Car(position = 2, name = "car2", generateMoveNumber = { 1 })
        val car3 = Car(position = 3, name = "car3", generateMoveNumber = { 1 })

        init(cars = listOf(car1, car2, car3))

        race.winners shouldBe listOf(car3)
    }

    @Test
    fun `when multiple cars have max position, getWinners should return all such cars`() {
        val car1 = Car(position = 1, name = "car", generateMoveNumber = { 1 })
        val car2 = Car(position = 2, name = "car2", generateMoveNumber = { 1 })
        val car3 = Car(position = 2, name = "car3", generateMoveNumber = { 1 })

        init(listOf(car1, car2, car3))

        race.winners shouldBe listOf(car2, car3)
    }

    @Test
    fun `generateRaceSequence should emit correct number of race updates`() {
        val cars =
            listOf(
                Car(position = 1, name = "car", generateMoveNumber = { 1 }),
                Car(position = 1, name = "car2", generateMoveNumber = { 1 }),
            )
        init(cars)

        val sequence = race.generateRaceSequence()
        val races = sequence.toList()

        races.size shouldBe 3
        races.last().round shouldBe 3
        races.forEach {
            it.cars.size shouldBe 2
        }
    }
}
