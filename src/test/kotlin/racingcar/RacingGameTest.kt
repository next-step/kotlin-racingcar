package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.RacingGame

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `RacingGame 의 초기 curAttemptNum 은 0 이다`(initCurAttemptNum: Int) {
        val racingGame = RacingGame(listOf("car_1", "car_2", "car_3"), 3)
        Assertions.assertThat(racingGame.curAttemptNum).isEqualTo(initCurAttemptNum)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `RacingGame 의 history size 는 시도 횟수와 같다`(attemptSize: Int) {
        val racingGame = RacingGame(listOf("car_1", "car_2", "car_3"), 10)
        repeat(attemptSize) {
            racingGame.attempt(
                List(racingGame.cars.size) {
                    0
                }
            )
        }
        Assertions.assertThat(racingGame.history.size).isEqualTo(attemptSize)
    }

    @Test
    fun `RacingGame 의 우승자는 제일 많이 움직인 Car 이고, 우승자는 한 명 이상일 수 있다`() {
        val racingGame = RacingGame(listOf("car_1", "car_2", "car_3"), 5)
        repeat(racingGame.attemptSize) {
            racingGame.attempt(
                listOf(9, 0, 0)
            )
        }
        Assertions.assertThat(racingGame.winners?.firstOrNull()?.name).isEqualTo("car_1")
    }
}
