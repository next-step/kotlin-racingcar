package com.nextstep.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `입력된 랜덤 숫자가 4보다 크거나 같으면 이동이 가능하다`() {
        val car = Car()

        car.move(4)

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `입력된 랜덤 숫자가 4보다 작으면 이동이 불가능하다`() {
        val car = Car()

        car.move(3)

        assertThat(car.position).isEqualTo(0)
    }
}
