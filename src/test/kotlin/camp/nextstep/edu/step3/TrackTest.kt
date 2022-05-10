package camp.nextstep.edu.step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
}
