package camp.nextstep.edu.step3.racing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class RacingTest {

    @DisplayName("1대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingSolo() {
        // Given
        val moveTwiceEngine = InstantEngine(2)
        val carId = 1
        val participants: List<Car> = listOf(Car(carId, moveTwiceEngine))
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
        Assertions.assertTrue(carTraces.next())
        Assertions.assertTrue(carTraces.next())
        Assertions.assertFalse(carTraces.next())
        Assertions.assertFalse(carTraces.next())
        Assertions.assertFalse(carTraces.next())
    }

    @DisplayName("2대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingDuo() {
        // Given
        val moveCount = 5
        val moveAllEngine = InstantEngine(moveCount)
        val moveOnceEngine = InstantEngine(1)

        val car1Id = 0
        val car2Id = 1
        val participants: List<Car> = listOf(
            Car(car1Id, moveAllEngine),
            Car(car2Id, moveOnceEngine)
        )
        val racing = Racing.new(participants, moveCount)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultIdMap = racing.result().mapKeys { it.key.id }
        assertNotNull(resultIdMap)
        assertEquals(2, resultIdMap.size)

        val car1Traces = requireNotNull(resultIdMap[car1Id]).traces()
        Assertions.assertTrue(car1Traces.next())
        Assertions.assertTrue(car1Traces.next())
        Assertions.assertTrue(car1Traces.next())
        Assertions.assertTrue(car1Traces.next())
        Assertions.assertTrue(car1Traces.next())

        val car2Traces = requireNotNull(resultIdMap[car2Id]).traces()
        Assertions.assertTrue(car2Traces.next())
        Assertions.assertFalse(car2Traces.next())
        Assertions.assertFalse(car2Traces.next())
        Assertions.assertFalse(car2Traces.next())
        Assertions.assertFalse(car2Traces.next())
    }
}
