package carracing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

class RacingTest {

    @Test
    fun `playRound - every car moves once`() {
        // given
        val cars = List(4) { Car(UUID.randomUUID().toString()) }
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
        val alwaysMoveRule = Rule.AlwaysMoveRule()
        val expectedMovingCount = linkedMapOf<String, Int>(
            "A" to 1,
            "B" to 0,
            "C" to 3
        )
        val cars = expectedMovingCount
            .map { (name, movingCount) ->
                Car(name).apply {
                    repeat(movingCount) { move(alwaysMoveRule.generateMovingFactor()) }
                }
            }
        val racing = Racing(cars = cars)

        // when
        val snapshot = racing.takeSnapshot()

        // then
        snapshot.trace.forEach { (name, movingCount) ->
            assertEquals(expectedMovingCount[name], movingCount)
        }
    }

    @Test
    fun `playRoundsWithSnapshots - play rounds 'numberOfAttempt' of times and returns a snapshot list for each round`() {
        // given
        val cars = List(4) { Car(UUID.randomUUID().toString()) }
        val racing = Racing(cars, Rule.AlwaysMoveRule())

        // when
        val snapshots = racing.playRoundsWithSnapshots(4)

        // then
        snapshots.forEachIndexed { index, snapshot ->
            val round = index + 1
            snapshot.trace.forEach { assertEquals(round, it.value) }
        }
    }
}
