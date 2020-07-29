package com.nextstep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    fun `자동차의 수가 0보다 작거나 같으면 에러가 발생한다`() {
        assertThrows(
            IllegalArgumentException::class.java
        ) {
            Cars(-1)
        }
    }

    @Test
    fun `입력한 수만큼 자동차를 생성한다`() {
        val cars = Cars(5)

        assertThat(cars.cars.size).isEqualTo(5)
    }
}
