package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import racingcar.domain.RacingGame

class RacingCarTest {

    @Test
    fun `자동차의 초기 위치는 0 이다`() {
        val car = Car()
        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자 값이 4 이상인 경우 자동차는 움직인다`(condition: Int) {
        val car = Car()
        car.move(condition)
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤 숫자 값이 4 미만인 경우 자동차는 움직이지 않는다`(condition: Int) {
        val car = Car()
        car.move(condition)
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `RacingGame 의 초기 curAttemptNum 은 0 이다`() {
        val racingGame = RacingGame(3, 3)
        assertThat(racingGame.curAttemptNum).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `RacingGame 의 history size 는 시도 횟수와 같다`(attemptSize: Int) {
        val racingGame = RacingGame(3, 10)
        repeat(attemptSize) {
            racingGame.attempt()
        }
        assertThat(racingGame.history.size).isEqualTo(attemptSize)
    }
}
