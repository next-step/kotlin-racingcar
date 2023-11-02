package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.rule.TestRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RacingGameTest {

    private val testNamesOfRacingCar = "pobi,crong,honux"

    @Test
    fun `자동차 이름 리스트와 시도할 횟수를 가지고 자동차 게임 생성`() {
        val racingGame = RacingGame(
            testNamesOfRacingCar, 5,
            RandomRacingGameMoveRule()
        )

        assertThat(racingGame).isNotNull
    }

    @Test
    fun `공백의 자동차 이름 리스트 입력시 자동차 게임 생성 에러`() {
        assertThatThrownBy { RacingGame("", 5, RandomRacingGameMoveRule()) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름 입력은 공백일 수 없습니다.")
    }

    @Test
    fun `레이싱 게임을 시작하면, 그 결과로 게임 결과를 반환`() {
        val racingGame = RacingGame(testNamesOfRacingCar, 5, RandomRacingGameMoveRule())

        val racingGameResult = racingGame.start()

        assertThat(racingGameResult).isNotNull()
        assertThat(racingGameResult.rounds).hasSize(5)
    }

    @Test
    fun `레이싱 게임을 시작하면, 그 결과로 게임 결과를 반환 - 전체 자동차가 모두 5번 앞으로 이동`() {
        val numOfAttempts = 5
        val racingGame = RacingGame(testNamesOfRacingCar, numOfAttempts, TestRacingGameMoveRule(true))

        val racingGameResult = racingGame.start()

        assertThat(racingGameResult).isNotNull()
        assertThat(racingGameResult.rounds).hasSize(5)
        for (attempt in 0 until numOfAttempts) {
            val currentRound = racingGameResult.rounds[attempt]
            assertThat(currentRound.roundNumber).isEqualTo(attempt + 1)
            currentRound.currentRacingCars.forEach {
                assertThat(it.name).isNotEmpty()
                assertThat(it.position).isEqualTo(attempt + 1)
            }
        }
    }

    @Test
    fun `레이싱 게임을 시작하면, 그 결과로 전체 라운드들을 반환 - 전체 자동차가 모든 시도에서 정지`() {
        val numOfAttempts = 5
        val racingGame = RacingGame(testNamesOfRacingCar, 5, TestRacingGameMoveRule(false))

        val racingGameResult = racingGame.start()

        assertThat(racingGameResult).isNotNull()
        assertThat(racingGameResult.rounds).hasSize(5)
        for (attempt in 0 until numOfAttempts) {
            val currentRound = racingGameResult.rounds[attempt]
            assertThat(currentRound.roundNumber).isEqualTo(attempt + 1)
            currentRound.currentRacingCars.forEach {
                assertThat(it.name).isNotEmpty()
                assertThat(it.position).isEqualTo(0)
            }
        }
    }
}