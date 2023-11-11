package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.RacingGame

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `RacingGame 의 초기 curAttemptNum 은 0 이다`(initCurAttemptNum: Int) {
        val racingGame = RacingGame(3, 3)
        Assertions.assertThat(racingGame.curAttemptNum).isEqualTo(initCurAttemptNum)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `RacingGame 의 history size 는 시도 횟수와 같다`(attemptSize: Int) {
        val racingGame = RacingGame(3, 10)
        repeat(attemptSize) {
            racingGame.attempt(
                List(racingGame.carSize) {
                    0
                }
            )
        }
        Assertions.assertThat(racingGame.history.size).isEqualTo(attemptSize)
    }
}
