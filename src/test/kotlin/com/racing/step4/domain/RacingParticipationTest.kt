package com.racing.step4.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingParticipationTest {
    @Test
    fun `레이싱 참여한 자동차들을 한 칸 강제로 이동시킨다`() {
        // given
        val carNumber = 2
        val carNameList = List(carNumber) { "car-$it" }
        val racingParticipation = RacingParticipation(carNameList)

        // when
        val moveTriggerFunc: () -> Int = { 5 } // 강제로 이동 시킨다
        racingParticipation.turnAround(moveTriggerFunc)

        // then
        racingParticipation.cars.forEach {
            assertThat(it.position).isEqualTo(1)
        }
    }

    @Test
    fun `동일한 위치에 있는 자동차들의 경우 공동우승자로 보여진다`() {
        // given
        val carNumber = 10
        val carNameList = List(carNumber) { "car-$it" }
        val racingParticipation = RacingParticipation(carNameList)

        // when
        val moveTriggerFunc: () -> Int = { 5 } // 강제로 이동 시킨다
        racingParticipation.turnAround(moveTriggerFunc)
        val winnerList = racingParticipation.findWinner()
        // then
        assertThat(winnerList.size).isEqualTo(carNumber)
    }
}
