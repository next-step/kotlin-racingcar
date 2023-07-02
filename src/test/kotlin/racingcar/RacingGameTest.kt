package racingcar

import controller.RacingGame
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `게임 참여하는 자동차 리스트 확인`() {
        val racingGame = RacingGame.create("A,B,C")
        racingGame.start()
        assertThat(racingGame.cars.size).isEqualTo(3)
    }
}
