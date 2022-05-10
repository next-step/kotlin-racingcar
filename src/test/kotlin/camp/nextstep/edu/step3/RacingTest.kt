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
import kotlin.random.Random

internal class RacingTest {

    @DisplayName("1대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingSolo() {
        // Given
        val id = 0
        val mockkRandom = mockk<Random>()
        mockkStatic("kotlin.random.RandomKt")
        every { mockkRandom.nextInt(0, 10) } returnsMany listOf(8, 9, 1, 2, 3)
        every { Random(id) } returns mockkRandom

        val racing = Racing.new(1, 5)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultMap = racing.result()
        assertNotNull(resultMap)
        assertEquals(1, resultMap.size)

        val carTrack = requireNotNull(resultMap.mapKeys { it.key.id }[id])
        Assertions.assertTrue(carTrack.isPassedAt(0))
        Assertions.assertTrue(carTrack.isPassedAt(1))
        Assertions.assertFalse(carTrack.isPassedAt(2))
        Assertions.assertFalse(carTrack.isPassedAt(3))
        Assertions.assertFalse(carTrack.isPassedAt(4))
    }

    @DisplayName("2대의 자동차가 트랙에서 경주를 할 수 있다.")
    @Test
    fun racingDuo() {
        // Given
        val car1Id = 0
        val car2Id = 1
        val car1EnginesRandom = mockk<Random>()
        val car2EnginesRandom = mockk<Random>()
        mockkStatic("kotlin.random.RandomKt")
        every { car1EnginesRandom.nextInt(0, 10) } returnsMany listOf(5, 5, 4, 5, 4)
        every { car2EnginesRandom.nextInt(0, 10) } returnsMany listOf(1, 2, 1, 3, 4)
        every { Random(car1Id) } returns car1EnginesRandom
        every { Random(car2Id) } returns car2EnginesRandom

        val racing = Racing.new(2, 5)

        // When
        assertDoesNotThrow {
            racing.start()
        }

        // Then
        val resultIdMap = racing.result().mapKeys { it.key.id }
        assertNotNull(resultIdMap)
        assertEquals(2, resultIdMap.size)

        val car1Track = requireNotNull(resultIdMap[car1Id])
        Assertions.assertTrue(car1Track.isPassedAt(0))
        Assertions.assertTrue(car1Track.isPassedAt(1))
        Assertions.assertTrue(car1Track.isPassedAt(2))
        Assertions.assertTrue(car1Track.isPassedAt(3))
        Assertions.assertTrue(car1Track.isPassedAt(4))

        val car2Track = requireNotNull(resultIdMap[car2Id])
        Assertions.assertTrue(car2Track.isPassedAt(0))
        Assertions.assertFalse(car2Track.isPassedAt(1))
        Assertions.assertFalse(car2Track.isPassedAt(2))
        Assertions.assertFalse(car2Track.isPassedAt(3))
        Assertions.assertFalse(car2Track.isPassedAt(4))
    }
}
