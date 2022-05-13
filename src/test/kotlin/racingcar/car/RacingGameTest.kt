package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.car.exception.GameOverException

class RacingGameTest {

    @Test
    fun `게임이 진행 가능 횟수 이상으로 게임을 하면, exception을 던진다`() {
        val testStrategy = AlwaysTrueMoveStrategy()
        val correctRacingGameInit = RacingGame(2, 1, testStrategy)
        val badRacingGameInitCase = RacingGame(2, 0, testStrategy)
        val badRacingGameInitCase2 = RacingGame(2, -1, testStrategy)

        assertThat(correctRacingGameInit.isPlayable()).isTrue
        assertThatThrownBy { badRacingGameInitCase.isPlayable() }.isInstanceOf(GameOverException::class.java)
        assertThatThrownBy { badRacingGameInitCase2.isPlayable() }.isInstanceOf(GameOverException::class.java)
    }

    @Test
    fun `게임이 진행되면 횟수가 감소한다`() {
        val racingGame = RacingGame(3, 5, AlwaysTrueMoveStrategy())
        racingGame.play()
        assertThat(racingGame.trialCount).isEqualTo(4)
    }
}
