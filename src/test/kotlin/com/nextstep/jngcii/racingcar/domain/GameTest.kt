package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {

    @Test
    fun `무조건 전진하는 Dice를 사용해 record에 기록하는 테스트`() {
        val carCount = 3
        val trialCount = 1
        val recordOf3CarAnd1Trial = Record(carCount, trialCount)
        val justTrueDice = object : Dice {
            override fun run() = true
        }

        Game(recordOf3CarAnd1Trial, justTrueDice).start()

        for (carIndex in 0 until carCount) {
            assertThat(recordOf3CarAnd1Trial.getGoCount(carIndex)).isEqualTo(trialCount)
        }
    }

    @Test
    fun `전진을 못하는 Dice를 사용해 record에 기록하는 테스트`() {
        val carCount = 3
        val trialCount = 10
        val recordOf3CarAnd10Trial = Record(carCount, trialCount)
        val justTrueDice = object : Dice {
            override fun run() = false
        }

        Game(recordOf3CarAnd10Trial, justTrueDice).start()

        for (carIndex in 0 until carCount) {
            assertThat(recordOf3CarAnd10Trial.getGoCount(carIndex)).isEqualTo(0)
        }
    }
}
