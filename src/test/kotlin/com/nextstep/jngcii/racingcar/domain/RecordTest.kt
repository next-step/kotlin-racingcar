package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class RecordTest {

    private lateinit var record: Record
    private val dummyCars = listOf(
        Car("peter"),
        Car("muzi")
    )

    @BeforeEach
    fun setUp() {
        record = Record(dummyCars)
    }

    @Test
    fun justGoTest() {
        val justGoDice = Dice { true }

        record.goOrStopEachCar(justGoDice)

        val actual = record.eachCarDistance
        val expected = List(dummyCars.size) { 1 }

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun justStopTest() {
        val justGoDice = Dice { false }

        record.goOrStopEachCar(justGoDice)

        val actual = record.eachCarDistance
        val expected = List(dummyCars.size) { 0 }

        assertThat(actual).isEqualTo(expected)
    }
}
