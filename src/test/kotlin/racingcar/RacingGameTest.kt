package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `경주 게임은 입력값만큼의 자동차를 생성한다`() {
        // given
        val racingGame = RacingGame()

        // when
        racingGame.set(3, 5)

        // then
        assertThat(racingGame.carList.size).isEqualTo(3)
    }

    @Test
    fun `경주 게임은 모든 자동차에 대해 무작위 값을 구하여 이동시킨다`() {
        // given
        val racingGame = RacingGame()
        racingGame.set(3, 1)

        // when
        racingGame.run()

        // then
        val cars = racingGame.carList
        val numbers = racingGame.randomNumberList[0]

        for (i in cars.indices) {
            if (numbers[i] >= 4) assertThat(cars[i].position).isEqualTo(1)
            else assertThat(cars[i].position).isEqualTo(0)
        }
    }
}
