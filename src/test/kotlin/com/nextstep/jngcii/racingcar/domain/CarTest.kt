package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car(SAMPLE_CAR_NAME)
    }

    @Test
    fun goTest() {
        assertThat(car.distance).isEqualTo(0)

        car.go()

        assertThat(car.distance).isEqualTo(1)
    }

    companion object {
        private const val SAMPLE_CAR_NAME = "peter"
    }
}
