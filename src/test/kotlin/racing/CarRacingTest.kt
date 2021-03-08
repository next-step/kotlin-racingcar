package racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CarRacingTest {
    private val cars = listOf(Car("서진혁"), Car("카샤"), Car("nextstep"))
    private val carRacing = CarRacing(cars, TRY_COUNT)

    @Test
    fun `차량 댓수와 repeat 횟수가 동일한지 확인한다`() {
        carRacing.execute()

        assertEquals(CAR_COUNT, cars.size)
        cars.forEach {
            assertEquals(TRY_COUNT, it.getRecords().size)
        }
    }

    @Test
    fun `승자끼리는 position이 항상 같아야한다`() {
        val winners = carRacing.getWinners()
        val positions = cars.filter { winners.contains(it) }.map { it.position }

        assertTrue(positions.max() == positions.min())
    }

    @Test
    fun `승자는 다른 사람보다 position 값이 커야한다`() {
        val winners = carRacing.getWinners()
        val losers = cars.filter { !winners.contains(it) }

        val winnerPosition = winners.map { it.position }.first()
        val losersMaxPosition = losers.map { it.position }.max() ?: 0

        assertTrue(losersMaxPosition < winnerPosition)
    }

    companion object {
        const val CAR_COUNT = 3
        const val TRY_COUNT = 7
    }
}
