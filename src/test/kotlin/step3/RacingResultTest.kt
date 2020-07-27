package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingResultTest {
    @Test
    fun `현재 레이싱 게임의 승자 가져오기`() {
        // given
        val racingResult = RacingResult(
            listOf(
                RacingTrack("A", 0),
                RacingTrack("B", 1),
                RacingTrack("C", 2),
                RacingTrack("D", 2)
            )
        )

        // then
        assertThat(racingResult.findCurrentWinners())
            .isEqualTo(listOf("C", "D"))
    }
}
