package me.parker.nextstep.kotlinracingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `자동차 대수와 시도할 횟수를 가지고 자동차 게임 생성`() {
        val racingGame = RacingGame(3, 5)

        assertThat(racingGame).isNotNull
        assertThat(racingGame.numOfRacingCar).isEqualTo(3)
        assertThat(racingGame.numOfAttempts).isEqualTo(5)
    }
}