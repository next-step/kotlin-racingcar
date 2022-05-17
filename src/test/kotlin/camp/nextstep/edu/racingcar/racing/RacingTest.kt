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

    @DisplayName("자동차가 경주를 마치면 각 자동차의 경주 이벤트 목록과 우승자 목록을 가져올 수 있다.")
    @Test
    fun racingTest() {
        // Given
        val car1 = Car(1, "twice", InstantEngine(2))
        val car2 = Car(2, "Five", InstantEngine(5))
        val car3 = Car(3, "Third", InstantEngine(3))
        val car4 = Car(4, "Five", InstantEngine(5))
        val participants: List<Car> = listOf(car1, car2, car3, car4)
        val racing = Racing.new(participants, 5)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val carRacingEvents = racing.carRacingEvents()
        assertNotNull(carRacingEvents)
        assertEquals(4, carRacingEvents.size)

        val car1sRaceEvents = requireNotNull(carRacingEvents.mapKeys { it.key.id }[car1.id])
        assertTrue(car1sRaceEvents[0].moved)
        assertTrue(car1sRaceEvents[1].moved)
        assertFalse(car1sRaceEvents[2].moved)
        assertFalse(car1sRaceEvents[3].moved)
        assertFalse(car1sRaceEvents[4].moved)

        val car2sRaceEvents = requireNotNull(carRacingEvents.mapKeys { it.key.id }[car2.id])
        assertTrue(car2sRaceEvents[0].moved)
        assertTrue(car2sRaceEvents[1].moved)
        assertTrue(car2sRaceEvents[2].moved)
        assertTrue(car2sRaceEvents[3].moved)
        assertTrue(car2sRaceEvents[4].moved)

        val car3sRaceEvents = requireNotNull(carRacingEvents.mapKeys { it.key.id }[car3.id])
        assertTrue(car3sRaceEvents[0].moved)
        assertTrue(car3sRaceEvents[1].moved)
        assertTrue(car3sRaceEvents[2].moved)
        assertFalse(car3sRaceEvents[3].moved)
        assertFalse(car3sRaceEvents[4].moved)

        val car4sRaceEvents = requireNotNull(carRacingEvents.mapKeys { it.key.id }[car4.id])
        assertTrue(car4sRaceEvents[0].moved)
        assertTrue(car4sRaceEvents[1].moved)
        assertTrue(car4sRaceEvents[2].moved)
        assertTrue(car4sRaceEvents[3].moved)
        assertTrue(car4sRaceEvents[4].moved)

        val winners = requireNotNull(racing.winners())
        assertEquals(2, racing.winners().size)
        assertTrue(participants.map { it.id }.containsAll(winners.map { it.id }))
    }

    @DisplayName("자동차 경주에 참여하는 자동차는 최소 1개 이상이어야 한다.")
    @Test
    internal fun shouldFailRacingParticipantsEmpty() {
        val moveCount = 5

        assertThrows<IllegalArgumentException> {
            Racing.new(listOf(), moveCount)
        }
    }

    @DisplayName("자동차 경주에서 자동차는 최소 1회 이상 움직일 수 있어야 한다.")
    @Test
    internal fun shouldFailRacingMoveCountZero() {
        val moveCount = 0
        val moveAllEngine = InstantEngine(moveCount)
        val moveOnceEngine = InstantEngine(1)

        val car1Id = 0
        val car2Id = 1
        val participants: List<Car> = listOf(
            Car(car1Id, "all", moveAllEngine),
            Car(car2Id, "once", moveOnceEngine)
        )

        assertThrows<IllegalArgumentException> {
            Racing.new(participants, moveCount)
        }
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
