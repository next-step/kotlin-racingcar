package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class HistoryTest {
    private lateinit var cars: Cars
    private lateinit var history: History

    @BeforeEach
    fun setUp() {
        cars = Cars(
            cars = listOf(Car("A"), Car("B"))
        )
        history = History(cars)
    }

    @Test
    fun `write할때마다 자동차들의 주행 상태를 기록한다 - go를 한번도 안하는 경우`() {
        assertThat(history.records.size).isEqualTo(0)

        history.write()

        assertThat(history.records.size).isEqualTo(1)
        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 0, "B" to 0)
            )
        )

        history.write()

        assertThat(history.records.size).isEqualTo(2)
        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 0, "B" to 0),
                mapOf("A" to 0, "B" to 0),
            )
        )
    }

    @Test
    fun `write할때마다 자동차들의 주행 상태를 기록한다 - 매번 go 이후 기록하는 경우`() {
        assertThat(history.records.size).isEqualTo(0)

        cars.forEach { it.goOrStayByDiceCondition() }
        history.write()

        assertThat(history.records.size).isEqualTo(1)
        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 1, "B" to 1)
            )
        )

        cars.forEach { it.goOrStayByDiceCondition() }
        history.write()

        assertThat(history.records.size).isEqualTo(2)
        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 1, "B" to 1),
                mapOf("A" to 2, "B" to 2)
            )
        )
    }
}
