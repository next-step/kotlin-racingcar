package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

internal class WinnersTest {

    @ParameterizedTest
    @MethodSource("arguments")
    fun `winner 산출 테스트`(
        carA: Car,
        carB: Car,
        carC: Car,
        expected: List<Car>
    ) {
        val cars = Cars(carA, carB, carC)

        assertThat(Winners(cars).cars).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arguments(): List<Arguments> {
            val car1A = Car(name = "A").goBy(1)
            val car1B = Car(name = "B").goBy(2)
            val car1C = Car(name = "C").goBy(3)

            val car2A = Car(name = "A").goBy(2)
            val car2B = Car(name = "B").goBy(1)
            val car2C = Car(name = "C").goBy(2)

            val car3A = Car(name = "A").goBy(1)
            val car3B = Car(name = "B").goBy(1)
            val car3C = Car(name = "C").goBy(1)

            return listOf(
                Arguments.of(car1A, car1B, car1C, listOf(car1C)),
                Arguments.of(car2A, car2B, car2C, listOf(car2A, car2C)),
                Arguments.of(car3A, car3B, car3C, listOf(car3A, car3B, car3C)),
            )
        }

        private fun Car.goBy(distance: Int): Car {
            repeat(distance) {
                this.go()
            }
            return this
        }
    }
}
