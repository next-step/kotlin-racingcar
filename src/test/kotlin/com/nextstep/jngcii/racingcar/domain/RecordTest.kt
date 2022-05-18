package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RecordTest {

    private lateinit var record: Record

    @BeforeEach
    fun setUp() {
        record = Record(CAR_COUNT)
    }

    @Test
    fun justGoTest() {
        val justGoDice = Dice { true }

        record.goOrStopEachCar(justGoDice)

        val actual = record.eachCarDrivenDistance
        val expected = List(CAR_COUNT) { DASH }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun justStopTest() {
        val justGoDice = Dice { false }

        record.goOrStopEachCar(justGoDice)

        val actual = record.eachCarDrivenDistance
        val expected = List(CAR_COUNT) { EMPTY_STRING }

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        private const val CAR_COUNT = 3
        private const val EMPTY_STRING = ""
        private const val DASH = "-"
    }
}
