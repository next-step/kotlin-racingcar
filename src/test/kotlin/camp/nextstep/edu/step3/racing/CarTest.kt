package camp.nextstep.edu.step3.racing

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarTest {

    @DisplayName("자동차는 트랙 위에서 달릴 수 있다.")
    @Test
    fun canRaceOnTrack() {
        // Given
        val id = 1
        val moveTwiceEngine: Engine = object : Engine {
            val returns = mutableListOf(MOVABLE_SPEED, MOVABLE_SPEED, NOT_MOVABLE_SPEED, NOT_MOVABLE_SPEED, NOT_MOVABLE_SPEED)
            override fun speed(): Int = returns.removeFirst()
        }
        val car = Car(id, moveTwiceEngine)

        val trackLength = 5
        val track = Track(trackLength)
        for (trace in track.traces()) {
            assertFalse(trace)
        }

        // When
        car.raceOn(track, 5)

        // Then
        val traces = track.traces()
        assertTrue(traces.next())
        assertTrue(traces.next())
        assertFalse(traces.next())
        assertFalse(traces.next())
        assertFalse(traces.next())
    }

    companion object {
        private const val MOVABLE_SPEED = 9
        private const val NOT_MOVABLE_SPEED = 0
    }
}
