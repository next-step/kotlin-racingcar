package com.racing.step4.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingParticipationTest {
    @Test
    fun `레이싱 참여한 자동차가 전진하는 로직이 제대로 동작하는지 확인`() {
        // given
        val car1 = Car("goofy1")
        val car2 = Car("goofy2")
        val carList = listOf<Car>(car1, car2)
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
    fun `최종 우승자가 제대로 동작하는지 확인한다`() {
        // given
        val car1 = Car("goofy1")
        val car2 = Car("goofy2")
        val carList = listOf<Car>(car1, car2)
        val racingParticipation = RacingParticipation(carList)

        // when
        val moveTriggerFunc: () -> Int = { 5 } // 강제로 이동 시킨다
        racingParticipation.turnAround(moveTriggerFunc)
        val winnerList = racingParticipation.findWinner()
        // then
        assertThat(winnerList.size).isEqualTo(2)
    }

    @Test
    fun `레이스 참가중인 자동차의 현재상태를 표시해주는 toString()`() {
        // given
        val car1 = Car("goofy1")
        val car2 = Car("goofy2")
        val carList = listOf<Car>(car1, car2)
        val racingParticipation = RacingParticipation(carList)
        val result = """
            goofy1 : --
            goofy2 : --
            
        """.trimIndent()

        // when
        val moveTriggerFunc: () -> Int = { 5 } // 강제로 이동 시킨다
        racingParticipation.turnAround(moveTriggerFunc)
        racingParticipation.turnAround(moveTriggerFunc)
        // then
        assertThat(racingParticipation.toString()).isEqualTo(result)
    }
}
