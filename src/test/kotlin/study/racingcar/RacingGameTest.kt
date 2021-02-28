package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingGameTest {

    @Test
    fun `게임 준비 후 자동차 array가 생성됐는지 확인`() {
        val racingGame = RacingGame()
        racingGame.readyGame(3)
        assertThat(racingGame.cars.size).isEqualTo(3)
    }
}
