package study

import domain.Car
import domain.RacingGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `게임 참여하는 자동차 리스트 확인`() {
        val cars = listOf(Car("A", 0), Car("B", 0))
        val racingGame = RacingGame(cars)
        assertThat(racingGame.getCars().size).isEqualTo(2)
    }
}
