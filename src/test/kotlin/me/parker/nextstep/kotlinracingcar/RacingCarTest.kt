package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.rule.TestRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `자동차 생성 - 최초 위치가 0인지 검증`() {
        val racingCar = RacingCar(RandomRacingGameMoveRule())

        assertThat(racingCar).isNotNull
        assertThat(racingCar.position).isEqualTo(0)
    }

    @Test
    fun `자동차 앞으로 이동`() {
        val racingCar = RacingCar(TestRacingGameMoveRule(true))

        racingCar.moveForward()

        assertThat(racingCar.position).isEqualTo(1)
    }

    @Test
    fun `자동차 앞으로 이동할 수 없음`() {
        val racingCar = RacingCar(TestRacingGameMoveRule(false))

        racingCar.moveForward()

        assertThat(racingCar.position).isEqualTo(0)
    }
}