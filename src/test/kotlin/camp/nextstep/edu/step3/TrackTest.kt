package camp.nextstep.edu.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.RuntimeException

internal class TrackTest {

    @DisplayName("자동차가 달린 흔적을 남길 수 있다.")
    @Test
    fun markCarTrace() {
        val track = Track(3)
        assertEquals(false, track.isPassedAt(0))
        assertEquals(false, track.isPassedAt(1))
        assertEquals(false, track.isPassedAt(2))

        track.markTrace()
        track.markTrace()

        assertEquals(true, track.isPassedAt(0))
        assertEquals(true, track.isPassedAt(1))
        assertEquals(false, track.isPassedAt(2))
    }

    @DisplayName("트랙 길이를 넘어서 흔적을 남길 수 없다.")
    @Test
    fun cannotMarkCarTraceOverTrack() {
        val track = Track(3)

        track.markTrace()
        track.markTrace()
        track.markTrace()

        assertThrows<RuntimeException> {
            track.markTrace()
        }
    }

    @DisplayName("트랙 밖의 흔적을 확인할 수 없다.")
    @ParameterizedTest(name = "{0} not include [0, 1, 2, 3, 4]")
    @ValueSource(ints = [-100, -10, -1, 5, 6, 10])
    fun cannotCheckCarTraceOverTrack(index: Int) {
        val track = Track(5)

        assertThrows<IllegalArgumentException> {
            track.isPassedAt(index)
        }
    }
}
