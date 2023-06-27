package racingcar

import controller.RacingGame
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
        val race = RacingGame.create("A,B,C") { 5 }
        race.start()

        assertThat(Winner(race.cars).getWinner()[0].name).isEqualTo("A")
    }

    @Test
    fun `자동차 게임이 끝나면 우승자가 총 몇 명인지 알려준다`() {
        val race = RacingGame.create("A,B,C") { 5 }
        race.start()

        assertThat(Winner(race.cars).getWinner().size).isEqualTo(3)
    }
}
