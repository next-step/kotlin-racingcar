package camp.nextstep.edu.racingcar.racing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

internal class RacingTest {

    @DisplayName("1대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingSolo() {
        // Given
        val moveTwiceEngine = InstantEngine(2)
        val carId = 1
        val participants: List<Car> = listOf(Car(carId, "twice", moveTwiceEngine))
        val racing = Racing.new(participants, 5)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultMap = racing.carRacingEvents()
        assertNotNull(resultMap)
        assertEquals(1, resultMap.size)

        val carRaceEvents = requireNotNull(resultMap.mapKeys { it.key.id }[carId])
        val track = CarRaceEvent.merge(carRaceEvents)
        val carTraces = track.traces()
        assertTrue(carTraces.next())
        assertTrue(carTraces.next())
        assertFalse(carTraces.next())
        assertFalse(carTraces.next())
        assertFalse(carTraces.next())

        assertEquals(1, racing.winners().size)
        assertTrue(racing.winners().containsAll(participants))
    }

    @DisplayName("경주가 끝나기 전, 결과를 요청할 수 없다.")
    @Test
    internal fun shouldFailGetResultBeforeEnded() {
        val moveCount = 5
        val moveAllEngine = InstantEngine(moveCount)
        val moveOnceEngine = InstantEngine(1)

        val car1Id = 0
        val car2Id = 1
        val participants: List<Car> = listOf(
            Car(car1Id, "all", moveAllEngine),
            Car(car2Id, "once", moveOnceEngine)
        )
        val racing = Racing.new(participants, moveCount)

        assertThrows<IllegalStateException> {
            racing.carRacingEvents()
        }
    }

    @DisplayName("경주가 끝나기 전, 우승자 리스트를 요청할 수 없다.")
    @Test
    internal fun shouldFailGetWinnersBeforeEnded() {
        val moveCount = 5
        val moveAllEngine = InstantEngine(moveCount)
        val moveOnceEngine = InstantEngine(1)

        val car1Id = 0
        val car2Id = 1
        val participants: List<Car> = listOf(
            Car(car1Id, "all", moveAllEngine),
            Car(car2Id, "once", moveOnceEngine)
        )
        val racing = Racing.new(participants, moveCount)

        assertThrows<IllegalStateException> {
            racing.winners()
        }
    }
}
