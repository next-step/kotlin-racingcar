package com.racing.step4.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingParticipationTest {
    @Test
    fun `레이싱 참여한 자동차들을 한 칸 강제로 이동시킨다`() {
        // given
        val carList = listOf<String>("car1", "car2")
        val racingParticipation = RacingParticipation(carList)

        // when
        val moveTriggerFunc: () -> Int = { 5 } // 강제로 이동 시킨다
        racingParticipation.turnAround(moveTriggerFunc)

        // then
        racingParticipation.cars.forEach {
            assertThat(it.position).isEqualTo(1)
        }
    }

    @Test
    fun `레이싱 참여한 자동차들이 동일한 위치에 존재하는 경우, 공동 우승을 보여준다`() {
        // given
        val carList = listOf<String>("car1", "car2")
        val racingParticipation = RacingParticipation(carList)

        // when
        val moveTriggerFunc: () -> Int = { 5 } // 강제로 이동 시킨다
        racingParticipation.turnAround(moveTriggerFunc)
        val winnerList = racingParticipation.findWinner()
        // then
        assertThat(winnerList.size).isEqualTo(2)
    }
}
