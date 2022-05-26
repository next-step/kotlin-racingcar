package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class HistoryTest {
    private lateinit var cars: Cars
    private lateinit var history: History

    @BeforeEach
    fun setUp() {
        cars = Cars(Car("A"), Car("B"))
        history = History(cars)
    }

    @Test
    fun `write할때마다 자동차들의 주행 상태를 기록한다 - go를 한번도 안하는 경우`() {
        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            emptyList<Map<String, Int>>()
        )

        history.write()

        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 0, "B" to 0)
            )
        )

        history.write()

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
        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            emptyList<Map<String, Int>>()
        )

        cars.forEach { it.goOrStayByDiceCondition() }
        history.write()

        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 1, "B" to 1)
            )
        )

        cars.forEach { it.goOrStayByDiceCondition() }
        history.write()

        assertThat(
            history.records.map { it.distanceByName }
        ).isEqualTo(
            listOf(
                mapOf("A" to 1, "B" to 1),
                mapOf("A" to 2, "B" to 2)
            )
        )
    }

    @ParameterizedTest
    @MethodSource("arguments")
    fun `winner 산출 테스트`(
        carA: Car,
        carB: Car,
        carC: Car,
        expected: List<String>
    ) {
        val history = History(
            cars = Cars(carA, carB, carC)
        )

        assertThat(history.winners).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arguments() = listOf(
            Arguments.of(
                Car(name = "A", advantage = 1),
                Car(name = "B", advantage = 2),
                Car(name = "C", advantage = 3),
                listOf("C")
            ),
            Arguments.of(
                Car(name = "A", advantage = 2),
                Car(name = "B", advantage = 1),
                Car(name = "C", advantage = 2),
                listOf("A", "C")
            ),
            Arguments.of(
                Car(name = "A", advantage = 1),
                Car(name = "B", advantage = 1),
                Car(name = "C", advantage = 1),
                listOf("A", "B", "C")
            ),
        )
    }
}
