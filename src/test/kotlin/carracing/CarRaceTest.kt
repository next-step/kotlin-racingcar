package carracing

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class CarRaceTest {
    @Test
    fun `when number of cars are less than 2 should throw exception with appropriate message`() {

        val cars = CarGenerator.generateCars(listOf("pobi"))

        val exception = assertFailsWith<IllegalArgumentException> {
            val race = CarRace(cars = cars, numRounds = 3)
            race.startRace()
        }
        assertEquals("Not enough cars to race", exception.message)
    }

    @Test
    fun `when number of rounds is zero should throw exception with appropriate message`() {
        val cars = CarGenerator.generateCars(listOf("pobi", "crong", "honux"))

        val exception = assertFailsWith<IllegalArgumentException> {
            val race = CarRace(cars = cars, numRounds = 0)
            race.startRace()
        }
        assertEquals("Select at least one round to start the race", exception.message)
    }

    @Test
    fun `race starts successfully when conditions are met`() {
        val cars = CarGenerator.generateCars(listOf("pobi", "crong"))

        val race = CarRace(cars = cars, numRounds = 5)
        race.startRace()

        assertEquals(2, race.cars.size)
        assertEquals(5, race.numRounds)
    }

    @Test
    fun `displays winner after race finishes successfully`() {
        val cars = CarGenerator.generateCars(listOf("pobi", "crong", "honux"))

        cars[0].position = 3 // pobi
        cars[1].position = 3 // crong (tied with pobi)
        cars[2].position = 1 // honux
        val race = CarRace(cars = cars, numRounds = 5)
        val winners = race.getWinners()

        assertEquals(2, winners.size)
    }
}
