package camp.nextstep.edu.model
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RacingGameTest {
    @Test
    fun playRound_carsMoveRandomly() {
        val cars = listOf(Car("car1"), Car("car2"))
        val initialPositions = cars.map { it.position }
        RacingGame.playRound(cars)
        val finalPositions = cars.map { it.position }
        finalPositions.forEachIndexed { index, finalPosition ->
            assertTrue(finalPosition >= initialPositions[index])
        }
    }

    @Test
    fun findWinners_singleWinner() {
        val cars = listOf(Car("car1", 2), Car("car2", 5), Car("car3", 3))
        val winners = RacingGame.findWinners(cars)
        assertEquals(listOf(Car("car2", 5)), winners)
    }

    @Test
    fun findWinners_multipleWinners() {
        val cars = listOf(Car("car1", 5), Car("car2", 5), Car("car3", 3))
        val winners = RacingGame.findWinners(cars)
        assertEquals(listOf(Car("car1", 5), Car("car2", 5)), winners)
    }

    @Test
    fun findWinners_noWinners() {
        val cars = emptyList<Car>()
        val winners = RacingGame.findWinners(cars)
        assertEquals(emptyList<Car>(), winners)
    }

    @Test
    fun findWinners_allCarsSamePosition() {
        val cars = listOf(Car("car1", 1), Car("car2", 1), Car("car3", 1))
        val winners = RacingGame.findWinners(cars)
        assertEquals(listOf(Car("car1", 1), Car("car2", 1), Car("car3", 1)), winners)
    }

    @Test
    fun findWinners_emptyCarsList() {
        val winners = RacingGame.findWinners(emptyList())
        assertTrue(winners.isEmpty())
    }
}