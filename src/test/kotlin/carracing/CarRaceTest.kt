package carracing

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class CarRaceTest {
    @Test
    fun `when number of cars are less than 2 should throw exception with appropriate message`() {
        val cars = CarGenerator.generateCars(1)

        val exception = assertFailsWith<IllegalArgumentException> {
            val race = CarRace(cars = cars, numRounds = 3)
            race.startRace()
        }
        assertEquals("Not enough cars to race", exception.message)
    }

    @Test
    fun `when number of rounds is zero should throw exception with appropriate message`() {
        val cars = CarGenerator.generateCars(3)

        val exception = assertFailsWith<IllegalArgumentException> {
            val race = CarRace(cars = cars, numRounds = 0)
            race.startRace()
        }
        assertEquals("Select at least one round to start the race", exception.message)
    }

    @Test
    fun `race starts successfully when conditions are met`() {
        val cars = CarGenerator.generateCars(2)

        val race = CarRace(cars = cars, numRounds = 5)
        race.startRace()

        assertEquals(2, race.cars.size)
        assertEquals(5, race.numRounds)
        assertNotEquals(race.cars[0].position, 0)
        assertNotEquals(race.cars[1].position, 0)
    }
}
