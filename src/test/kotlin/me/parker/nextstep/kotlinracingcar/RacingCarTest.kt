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

    @Test
    fun `copy시 같은 정보의 다른 객체를 반환`() {
        val racingCar = RacingCar(TestRacingGameMoveRule(true))

        val copiedRacingCar = racingCar.copy()

        assertThat(racingCar).isNotSameAs(copiedRacingCar)
        assertThat(racingCar.position).isEqualTo(copiedRacingCar.position)

        racingCar.moveForward()

        val copiedRacingCar2 = racingCar.copy()

        assertThat(racingCar).isNotSameAs(copiedRacingCar2)
        assertThat(racingCar.position).isEqualTo(copiedRacingCar2.position)
        assertThat(copiedRacingCar).isNotSameAs(copiedRacingCar2)
        assertThat(copiedRacingCar.position + 1).isEqualTo(copiedRacingCar2.position)
    }
}