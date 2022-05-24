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
                PrefixCar(name = "A", distance = 10),
                PrefixCar(name = "B", distance = 20),
                PrefixCar(name = "C", distance = 30),
                listOf("C")
            ),
            Arguments.of(
                PrefixCar(name = "A", distance = 30),
                PrefixCar(name = "B", distance = 20),
                PrefixCar(name = "C", distance = 30),
                listOf("A", "C")
            ),
            Arguments.of(
                PrefixCar(name = "A", distance = 10),
                PrefixCar(name = "B", distance = 10),
                PrefixCar(name = "C", distance = 10),
                listOf("A", "B", "C")
            ),
        )
    }

    private class PrefixCar(
        name: String,
        override val distance: Int
    ) : Car(name)
}
