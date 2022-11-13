package com.jay.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RacingCarsTest {
    @Test
    fun `자동차들을 생성한다`() {
        val racingCars = RacingCars.create(Names(listOf("jay", "pobi", "honux")), forwardStrategy())

        assertThat(racingCars.racingCars.size).isEqualTo(3)
    }

    @Test
    fun `게임을 플레이하면 Strategy에 기반한 위치를 반환한다`() {
        val racingCars = RacingCars.create(Names(listOf("jay", "pobi", "honux")), forwardStrategy())

        racingCars.play()

        racingCars.racingCars.forEach {
            assertThat(it.getPosition()).isEqualTo(1)
        }
    }

    @Test
    fun `우승자의 목록을 반환한다`() {
        val racingCars = RacingCars.create(Names(listOf("jay", "pobi", "honux")), forwardStrategy())
        val winnerNames = racingCars.getWinners().map { it.getNameValue() }.toList()

        assertThat(winnerNames).containsAll(listOf("jay", "pobi", "honux"))
    }

    private fun forwardStrategy() = object : MovingStrategy {
        override fun canMove(): Boolean {
            return true
        }
    }
}
