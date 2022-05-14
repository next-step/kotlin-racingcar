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
        val resultMap = racing.result()
        assertNotNull(resultMap)
        assertEquals(1, resultMap.size)

        val carTraces = requireNotNull(resultMap.mapKeys { it.key.id }[carId]).traces()
        assertTrue(carTraces.next())
        assertTrue(carTraces.next())
        assertFalse(carTraces.next())
        assertFalse(carTraces.next())
        assertFalse(carTraces.next())

        assertEquals(1, racing.winners().size)
        assertTrue(racing.winners().containsAll(participants))
    }

    @DisplayName("2대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingDuo() {
        // Given
        val moveCount = 5
        val moveAllEngine = InstantEngine(moveCount)
        val moveOnceEngine = InstantEngine(1)

        val car1 = Car(0, "all", moveAllEngine)
        val car2 = Car(1, "once", moveOnceEngine)
        val participants: List<Car> = listOf(car1, car2)
        val racing = Racing.new(participants, moveCount)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultIdMap = racing.result().mapKeys { it.key.id }
        assertNotNull(resultIdMap)
        assertEquals(2, resultIdMap.size)

        val car1Traces = requireNotNull(resultIdMap[car1.id]).traces()
        assertTrue(car1Traces.next())
        assertTrue(car1Traces.next())
        assertTrue(car1Traces.next())
        assertTrue(car1Traces.next())
        assertTrue(car1Traces.next())

        val car2Traces = requireNotNull(resultIdMap[car2.id]).traces()
        assertTrue(car2Traces.next())
        assertFalse(car2Traces.next())
        assertFalse(car2Traces.next())
        assertFalse(car2Traces.next())
        assertFalse(car2Traces.next())

        assertEquals(1, racing.winners().size)
        assertTrue(racing.winners().contains(car1))
    }

    @DisplayName("3대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingTrio() {
        // Given
        val moveCount = 5

        val car1 = Car(0, "three", InstantEngine(3))
        val car2 = Car(1, "once", InstantEngine(1))
        val car3 = Car(2, "three", InstantEngine(3))
        val participants: List<Car> = listOf(car1, car2, car3)
        val racing = Racing.new(participants, moveCount)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultIdMap = racing.result().mapKeys { it.key.id }
        assertNotNull(resultIdMap)
        assertEquals(3, resultIdMap.size)

        val car1Traces = requireNotNull(resultIdMap[car1.id]).traces()
        assertTrue(car1Traces.next())
        assertTrue(car1Traces.next())
        assertTrue(car1Traces.next())
        assertFalse(car1Traces.next())
        assertFalse(car1Traces.next())

        val car2Traces = requireNotNull(resultIdMap[car2.id]).traces()
        assertTrue(car2Traces.next())
        assertFalse(car2Traces.next())
        assertFalse(car2Traces.next())
        assertFalse(car2Traces.next())
        assertFalse(car2Traces.next())

        val car3Traces = requireNotNull(resultIdMap[car3.id]).traces()
        assertTrue(car3Traces.next())
        assertTrue(car3Traces.next())
        assertTrue(car3Traces.next())
        assertFalse(car3Traces.next())
        assertFalse(car3Traces.next())

        assertEquals(2, racing.winners().size)
        assertTrue(racing.winners().contains(car1))
        assertTrue(racing.winners().contains(car3))
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
            racing.result()
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
