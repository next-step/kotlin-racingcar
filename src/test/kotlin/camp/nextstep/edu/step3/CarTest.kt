package camp.nextstep.edu.step3

import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Instant
import kotlin.random.Random

internal class CarTest {

    @DisplayName("자동차는 트랙 위에서 달릴 수 있다.")
    @Test
    fun canRaceOnTrack() {
        // Given
        val now = Instant.now()
        mockkStatic("java.time.Instant")
        every { Instant.now() } returns now

        val id = 1
        val mockkRandom = mockk<Random>()
        mockkStatic("kotlin.random.RandomKt")
        every { mockkRandom.nextInt(0, 10) } returnsMany listOf(8, 9, 1, 2, 3)
        every { Random(id * now.nano) } returns mockkRandom
        val car = Car(id)

        val trackLength = 5
        val track = Track(trackLength)
        assertFalse(track.isPassedAt(0))
        assertFalse(track.isPassedAt(1))
        assertFalse(track.isPassedAt(2))
        assertFalse(track.isPassedAt(3))
        assertFalse(track.isPassedAt(4))

        // When
        car.raceOn(track, 5)

        // Then
        assertTrue(track.isPassedAt(0))
        assertTrue(track.isPassedAt(1))
        assertFalse(track.isPassedAt(2))
        assertFalse(track.isPassedAt(3))
        assertFalse(track.isPassedAt(4))
    }
}
