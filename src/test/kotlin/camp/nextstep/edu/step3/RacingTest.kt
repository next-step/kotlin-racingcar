package camp.nextstep.edu.step3

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.time.Instant
import kotlin.random.Random

internal class RacingTest {

    @DisplayName("1대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingSolo() {
        // Given
        val now = Instant.now()
        mockkStatic("java.time.Instant")
        every { Instant.now() } returns now

        val id = 0
        val mockkRandom = mockk<Random>()
        mockkStatic("kotlin.random.RandomKt")
        every { mockkRandom.nextInt(0, 10) } returnsMany listOf(8, 9, 1, 2, 3)
        every { Random(id * now.nano) } returns mockkRandom

        val racing = Racing.new(1, 5)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultMap = racing.result()
        assertNotNull(resultMap)
        assertEquals(1, resultMap.size)

        val carTraces = requireNotNull(resultMap.mapKeys { it.key.id }[id]).traces()
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
        val now = Instant.now()
        mockkStatic("java.time.Instant")
        every { Instant.now() } returns now

        val car1Id = 0
        val car2Id = 1
        val car1EnginesRandom = mockk<Random>()
        val car2EnginesRandom = mockk<Random>()
        mockkStatic("kotlin.random.RandomKt")
        every { car1EnginesRandom.nextInt(0, 10) } returnsMany listOf(5, 5, 4, 5, 4)
        every { car2EnginesRandom.nextInt(0, 10) } returnsMany listOf(1, 2, 1, 3, 4)
        every { Random(car1Id * now.nano) } returns car1EnginesRandom
        every { Random(car2Id * now.nano) } returns car2EnginesRandom

        val racing = Racing.new(2, 5)

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
