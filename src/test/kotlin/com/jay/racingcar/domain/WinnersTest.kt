package com.jay.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WinnersTest {
    @Test
    fun `우승자의 목록을 반환한다`() {
        val racingCars = RacingCars.create(Names(listOf("jay", "pobi", "honux")), forwardStrategy())
        val winnerNames = Winners(racingCars).getWinnerNames()

        assertThat(winnerNames).containsAll(listOf("jay", "pobi", "honux"))
    }

    private fun forwardStrategy() = object : MovingStrategy {
        override fun canMove(): Boolean {
            return true
        }
    }
}
