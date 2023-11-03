package me.parker.nextstep.kotlinracingcar.domain

import me.parker.nextstep.kotlinracingcar.domain.RacingCar
import me.parker.nextstep.kotlinracingcar.domain.RacingCarGameRound
import me.parker.nextstep.kotlinracingcar.domain.RacingGameResult
import me.parker.nextstep.kotlinracingcar.domain.Winners
import me.parker.nextstep.kotlinracingcar.domain.rule.RandomRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameResultTest {

    @Test
    fun `레이싱 게임 결과는 라운드 정보와 우승자 정보를 모두 저장한다`() {
        val racingCar = RacingCar("park", RandomRacingGameMoveRule())
        val racingCarGameRound1 = RacingCarGameRound(1, listOf(racingCar))
        val racingCarGameRound2 = RacingCarGameRound(2, listOf(racingCar))

        val winners = Winners(listOf(racingCar))

        val racingGameResult = RacingGameResult(listOf(racingCarGameRound1, racingCarGameRound2), winners)

        assertThat(racingGameResult).isNotNull()
        assertThat(racingGameResult.rounds).isNotNull()
        assertThat(racingGameResult.rounds).hasSize(2)
        assertThat(racingGameResult.winners).isNotNull()
    }
}