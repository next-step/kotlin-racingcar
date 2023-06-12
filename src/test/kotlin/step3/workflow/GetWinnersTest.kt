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
            RacingCar(UUID.randomUUID().toString(), 0),
            RacingCar("winner", 6),
            RacingCar(UUID.randomUUID().toString(), 5),
            RacingCar(UUID.randomUUID().toString(), 3),
            RacingCar(UUID.randomUUID().toString(), 2),
        )
        val winners = getWinners(racingCars)
        assertEquals(1, winners.size)
        assertEquals("winner", winners[0].name)
    }

    @Test
    fun `there is several winners, then return several winner`() {
        val winnerName = UUID.randomUUID().toString()
        val racingCars = listOf(
            RacingCar(UUID.randomUUID().toString(), 0),
            RacingCar(UUID.randomUUID().toString(), 2),
            RacingCar(winnerName, 6),
            RacingCar(winnerName, 6),
            RacingCar(winnerName, 6),
        )
        val winners = getWinners(racingCars)
        assertEquals(3, winners.size)
        winners.forEach { assertEquals(winnerName, it.name) }
    }
}
