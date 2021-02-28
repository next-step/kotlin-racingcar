package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    @Test
    fun `게임 준비가 완료되었는지 확인`() {
        val racingGame = RacingGame(RandomMoveCarStrategy())
        assertThat(racingGame.readyGame(3)).isEqualTo(true)
    }
}
