package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class GameTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `자동차 스피드에 따라 시도횟수만큼 전진하는지 테스트`(speed: Int) {
        val fakeCars = List(CAR_COUNT) { FakeCar(speed) }
        val dice = Dice { true }
        val game = Game(fakeCars, TRIAL_COUNT, dice)

        game.start { }

        val actual = fakeCars.map { it.distance }
        val expected = List(CAR_COUNT) { TRIAL_COUNT * speed }
        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        private const val CAR_COUNT = 2
        private const val TRIAL_COUNT = 3
    }

    private class FakeCar(
        override val speed: Int
    ) : Car("FAKE")
}
