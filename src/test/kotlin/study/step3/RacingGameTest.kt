package study.step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    @Test
    fun `게임 준비 후 자동차 array가 생성됐는지 확인`() {
        val racingGame = RacingGame()
        racingGame.readyGame(3)
        assertThat(racingGame.cars.size).isEqualTo(3)
    }

    @Test
    fun `0~9 사이의 값을 넣으면 자동차가 움직이는 지 확인`() {
        val racingGame = RacingGame()
        racingGame.readyGame(3)
        val car = racingGame.cars[0]
        val distance = car.distance
        racingGame.moveCarOrNot(9, racingGame.cars[0])

        assertThat(distance).isNotEqualTo(car.distance)
    }
}
