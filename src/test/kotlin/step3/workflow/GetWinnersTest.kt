package step3.workflow

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import step3.entity.RacingCar
import java.util.UUID

internal class GetWinnersTest {
    private val getWinners = GetWinners()

    @Test
    fun `there is only one winner, then return one winner`() {
        val racingCars = listOf(
            RacingCar(makeRandomName(), 0),
            RacingCar("winne", 6),
            RacingCar(makeRandomName(), 5),
            RacingCar(makeRandomName(), 3),
            RacingCar(makeRandomName(), 2),
        )
        val winners = getWinners(racingCars)
        assertEquals(1, winners.size)
        assertEquals("winne", winners[0].name)
    }

    @Test
    fun `there is several winners, then return several winner`() {
        val winnerName = makeRandomName()
        val racingCars = listOf(
            RacingCar(makeRandomName(), 0),
            RacingCar(makeRandomName(), 2),
            RacingCar(winnerName, 6),
            RacingCar(winnerName, 6),
            RacingCar(winnerName, 6),
        )
        val winners = getWinners(racingCars)
        assertEquals(3, winners.size)
        winners.forEach { assertEquals(winnerName, it.name) }
    }

    private fun makeRandomName(): String = UUID.randomUUID().toString().substring(0, 5)
}
