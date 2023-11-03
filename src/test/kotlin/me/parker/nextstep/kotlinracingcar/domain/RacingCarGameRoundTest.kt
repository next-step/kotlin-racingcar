package me.parker.nextstep.kotlinracingcar.domain

import me.parker.nextstep.kotlinracingcar.domain.RacingCar
import me.parker.nextstep.kotlinracingcar.domain.RacingCarGameRound
import me.parker.nextstep.kotlinracingcar.domain.rule.RandomRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarGameRoundTest {

    @Test
    fun `레이싱 게임 기록은 라운드 정보와 해당 라운드의 모든 레이싱카 정보를 갖는다`() {
        val racingCarGameRound = RacingCarGameRound(1, listOf(
            RacingCar("park1", RandomRacingGameMoveRule()),
            RacingCar("park2", RandomRacingGameMoveRule()),
            RacingCar("park3", RandomRacingGameMoveRule())
        ))

        assertThat(racingCarGameRound).isNotNull()
        assertThat(racingCarGameRound.roundNumber).isEqualTo(1)
        assertThat(racingCarGameRound.currentRacingCars).hasSize(3)
    }
}