package step3.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import step3.racingcar.car.exception.GameOverException

class RacingGameTest {

    @Test
    fun `게임이 진행 가능 횟수 이상으로 게임을 하면, exception을 던진다`() {
        val correctRacingGameInit = RacingGame.init(2, 1)
        val badRacingGameInitCase = RacingGame.init(2, 0)
        val badRacingGameInitCase2 = RacingGame.init(2, -1)

        assertThat(correctRacingGameInit.isPlayable()).isTrue
        assertThatThrownBy { badRacingGameInitCase.isPlayable() }.isInstanceOf(GameOverException::class.java)
        assertThatThrownBy { badRacingGameInitCase2.isPlayable() }.isInstanceOf(GameOverException::class.java)
    }
}
