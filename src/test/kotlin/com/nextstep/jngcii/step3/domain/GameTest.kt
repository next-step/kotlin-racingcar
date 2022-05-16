package com.nextstep.jngcii.step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameTest {

    private val justTrueDice = object : Dice {
        override fun run() = true
    }

    @Test
    fun `무조건 전진하는 Dice를 사용해 record에 기록하는 테스트`() {
        val carCount = 3
        val trialCount = 1
        val recordOf3CarAnd1Trial = Record(carCount, trialCount)

        Game(recordOf3CarAnd1Trial, justTrueDice).start()

        for (carIndex in 0 until carCount) {
            assertThat(recordOf3CarAnd1Trial.getGoCount(carIndex)).isEqualTo(trialCount)
        }
    }
}
