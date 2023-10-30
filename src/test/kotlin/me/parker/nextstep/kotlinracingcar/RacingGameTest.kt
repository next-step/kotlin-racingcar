package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.rule.TestRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `자동차 대수와 시도할 횟수를 가지고 자동차 게임 생성`() {
        val racingGame = RacingGame(3, 5, RandomRacingGameMoveRule())

        assertThat(racingGame).isNotNull
        assertThat(racingGame.numOfRacingCar).isEqualTo(3)
        assertThat(racingGame.numOfAttempts).isEqualTo(5)
    }

    @Test
    fun `레이싱 게임을 시작하면, 그 결과로 전체 자동차를 반환`() {
        val racingGame = RacingGame(3, 5, RandomRacingGameMoveRule())

        // val movedRacingCars = racingGame.start()
    }
}