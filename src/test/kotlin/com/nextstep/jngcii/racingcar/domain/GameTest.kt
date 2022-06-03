package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class GameTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `자동차 스피드에 따라 시도횟수만큼 전진하는지 테스트`(speed: Int) {
        val cars = Array(CAR_COUNT) { Car(name = "fake", speed = speed) }
        val fakeCars = Cars(*cars)
        val history = History(fakeCars)
        val game = Game(fakeCars, TRIAL_COUNT, history)

        val winners = game.start()

        fakeCars.forEach {
            assertThat(it.distance).isEqualTo(TRIAL_COUNT * speed)
        }
        assertThat(winners.cars).isEqualTo(cars.toList())
    }

    companion object {
        private const val CAR_COUNT = 2
        private const val TRIAL_COUNT = 3
    }
}
