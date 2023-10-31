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
    fun `레이싱 게임을 시작하면, 그 결과로 전체 라운드들을 반환`() {
        val racingGame = RacingGame(3, 5, RandomRacingGameMoveRule())

        val racingCarRecords = racingGame.start()

        assertThat(racingCarRecords).hasSize(5)
    }

    @Test
    fun `레이싱 게임을 시작하면, 그 결과로 전체 라운드들을 반환 - 전체 자동차가 모두 5번 앞으로 이동`() {
        val numOfAttempts = 5
        val racingGame = RacingGame(3, numOfAttempts, TestRacingGameMoveRule(true))

        val racingCarRecords = racingGame.start()

        assertThat(racingCarRecords).hasSize(5)
        for (attempt in 0 until numOfAttempts) {
            val currentRound = racingCarRecords[attempt]
            assertThat(currentRound.roundNumber).isEqualTo(attempt + 1)
            currentRound.currentRacingCars.forEach { assertThat(it.position).isEqualTo(attempt + 1) }
        }
    }

    @Test
    fun `레이싱 게임을 시작하면, 그 결과로 전체 라운드들을 반환 - 전체 자동차가 모든 시도에서 정지`() {
        val numOfAttempts = 5
        val racingGame = RacingGame(3, 5, TestRacingGameMoveRule(false))

        val racingCarRecords = racingGame.start()

        assertThat(racingCarRecords).hasSize(5)
        for (attempt in 0 until numOfAttempts) {
            val currentRound = racingCarRecords[attempt]
            assertThat(currentRound.roundNumber).isEqualTo(attempt + 1)
            currentRound.currentRacingCars.forEach { assertThat(it.position).isEqualTo(0) }
        }
    }
}