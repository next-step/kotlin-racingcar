package carracing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RacingTest {

    @Test
    fun `playRound - every car moves once`() {
        // given
        val cars = List(4) { Car() }
        val racing = Racing(cars, Rule.AlwaysMoveRule())

        // when
        racing.playRound()

        // then
        racing.cars.forEach {
            assertEquals(1, it.movingCount)
        }
    }

    @Test
    fun `takeSnapshot - return the current movingCount of all car`() {
        // given
        val expectedMovingCount = listOf(1, 0, 2)
        val alwaysMoveRule = Rule.AlwaysMoveRule()
        val cars = expectedMovingCount
            .map {
                Car().apply {
                    repeat(it) { move(alwaysMoveRule.generateMovingFactor()) }
                }
            }
        val racing = Racing(cars = cars)

        // when
        val snapshot = racing.takeSnapshot()

        // then
        snapshot.forEachIndexed { index, movingCount ->
            assertEquals(expectedMovingCount[index], movingCount)
        }
    }

    @Test
    fun `playRoundsWithSnapshots - play rounds numberOfAttempt of times and returns a snapshot list for each round`() {
        // given
        val cars = List(4) { Car() }
        val racing = Racing(cars, Rule.AlwaysMoveRule())

        // when
        val snapshots = racing.playRoundsWithSnapshots(4)

        // then
        snapshots.forEachIndexed { index, snapshot ->
            val round = index + 1
            snapshot.forEach { assertEquals(round, it) }
        }
    }
}
