package me.parker.nextstep.kotlinracingcar

import me.parker.nextstep.kotlinracingcar.rule.RandomRacingGameMoveRule
import me.parker.nextstep.kotlinracingcar.rule.TestRacingGameMoveRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnersTest {

    @Test
    fun `레이싱 자동차 리스트를 받으면 우승자를 반환하는 Winners 객체`() {
        val winners = Winners(listOf(RacingCar("park", RandomRacingGameMoveRule())))

        assertThat(winners).isNotNull()
        assertThat(winners.racingCars).hasSize(1)
    }

    @Test
    fun `3명 중 우승자가 한 명인 경우`() {
        val racingCar1 = RacingCar("park1", TestRacingGameMoveRule(true))
        val racingCar2 = RacingCar("park2", TestRacingGameMoveRule(true))
        val racingCar3 = RacingCar("park3", TestRacingGameMoveRule(true))
        racingCar3.moveForward()

        val winners = Winners(listOf(racingCar1, racingCar2, racingCar3))

        assertThat(winners).isNotNull()
        assertThat(winners.racingCars).hasSize(1)
        assertThat(winners.racingCars[0]).isEqualTo(racingCar3)
    }

    @Test
    fun `3명 중 우승자가 2명인 경우`() {
        val racingCar1 = RacingCar("park1", TestRacingGameMoveRule(true))
        val racingCar2 = RacingCar("park2", TestRacingGameMoveRule(true))
        racingCar2.moveForward()
        val racingCar3 = RacingCar("park3", TestRacingGameMoveRule(true))
        racingCar3.moveForward()

        val winners = Winners(listOf(racingCar1, racingCar2, racingCar3))

        assertThat(winners).isNotNull()
        assertThat(winners.racingCars).hasSize(2)
    }

    @Test
    fun `3명 중 전체가 우승자인 경우`() {
        val racingCar1 = RacingCar("park1", TestRacingGameMoveRule(true))
        racingCar1.moveForward()
        val racingCar2 = RacingCar("park2", TestRacingGameMoveRule(true))
        racingCar2.moveForward()
        val racingCar3 = RacingCar("park3", TestRacingGameMoveRule(true))
        racingCar3.moveForward()

        val winners = Winners(listOf(racingCar1, racingCar2, racingCar3))

        assertThat(winners).isNotNull()
        assertThat(winners.racingCars).hasSize(3)
    }
}