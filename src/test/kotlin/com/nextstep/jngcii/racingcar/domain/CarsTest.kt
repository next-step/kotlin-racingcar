package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class CarsTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `winners 확인 테스트`(carA: Car, carB: Car, carC: Car, expected: List<String>) {
        val cars = Cars(cars = listOf(carA, carB, carC))

        Assertions.assertThat(cars.winners.map { it.name }).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arguments() = listOf(
            Arguments.of(
                Car(name = "A").goBy(10),
                Car(name = "B").goBy(20),
                Car(name = "C").goBy(30),
                listOf("C")
            ),
            Arguments.of(
                Car(name = "A").goBy(20),
                Car(name = "B").goBy(10),
                Car(name = "C").goBy(20),
                listOf("A", "C")
            ),
            Arguments.of(
                Car(name = "A").goBy(10),
                Car(name = "B").goBy(10),
                Car(name = "C").goBy(10),
                listOf("A", "B", "C")
            ),
        )

        private fun Car.goBy(times: Int): Car {
            repeat(times) { this.goOrStayByDiceCondition() }
            return this
        }
    }
}
