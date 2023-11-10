package carracing.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingTest {

    @Test
    fun `playRound - every car moves once`() {
        // given
        val cars = List(4) { Car(generateCarName()) }
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
            generateCarName() to 1,
            generateCarName() to 0,
            generateCarName() to 3,
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
        val cars = List(4) { Car(generateCarName()) }
        val racing = Racing(cars, Rule.AlwaysMoveRule())

        // when
        val snapshots = racing.playRoundsWithSnapshots(4)

        // then
        snapshots.forEachIndexed { index, snapshot ->
            val round = index + 1
            snapshot.trace.forEach { assertEquals(round, it.value) }
        }
    }

    @Test
    fun `winners - if check the winners before the race finish, throw IllegalStateException`() {
        // given
        val racing = Racing(cars = List(4) { Car(generateCarName()) })

        // when, then
        assertThrows<IllegalStateException> { racing.winners }
    }

    @Test
    fun `winners - once decided, the winners doesn't change when we play more rounds`() {
        // given
        val racing = Racing(cars = List(4) { Car(generateCarName()) })

        // when
        val winners = racing.finish()
        racing.playRound()

        // then
        assertIterableEquals(winners, racing.winners)
    }

    @Test
    fun `finish - finish racing, determine the winners and return`() {
        // given
        val racing = Racing(cars = List(4) { Car(generateCarName()) })

        // when
        val winners = racing.finish()

        // then
        assertEquals(true, racing.isFinish)
        assertTrue(winners.size > 1)
    }

    @Test
    fun `finish - if going to finish already finished racing, throw IllegalStateException`() {
        // given
        val racing = Racing(cars = List(4) { Car(generateCarName()) })
        racing.finish()

        // when, then
        assertThrows<IllegalStateException> { racing.finish() }
    }
}
