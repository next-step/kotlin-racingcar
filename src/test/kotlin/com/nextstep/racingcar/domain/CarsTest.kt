package com.nextstep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    internal fun `승자를 찾는 테스트`() {
        val car1 = Car("van", 1)
        val car2 = Car("harry", 2)
        val car3 = Car("bedi", 3)
        val car4 = Car("done", 3)

        val cars = Cars(listOf<Car>(car1, car2, car3, car4))

        val winners = cars.findWinner()

        assertThat(winners.cars.size).isEqualTo(2)
        assertThat(winners.cars).contains(Car("done", 3))
        assertThat(winners.cars).contains(Car("bedi", 3))
    }
}
