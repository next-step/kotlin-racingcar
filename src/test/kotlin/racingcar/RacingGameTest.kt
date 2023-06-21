package racingcar

import domain.RacingGame
import domain.Winner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `게임 참여하는 자동차 리스트 확인`() {
        val racingGame = RacingGame.create("A,B,C") { 0 }
        racingGame.start()
        assertThat(racingGame.cars.size).isEqualTo(3)
    }

    @Test
    fun `자동차 게임이 끝나면 우승자를 알려준다`() {
        val race = RacingGame.create("A,B,C") { 0 }
        val cars = race.start()
        cars[0].move(5)
        cars[1].move(3)
        cars[2].move(3)

        assertThat(Winner(cars).getWinner()[0].name).isEqualTo("A")
    }
}
