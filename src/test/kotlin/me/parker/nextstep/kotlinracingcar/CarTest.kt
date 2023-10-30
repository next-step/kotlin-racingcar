package me.parker.nextstep.kotlinracingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 생성 - 최초 위치가 0인지 검증`() {
        val car = Car()

        assertThat(car).isNotNull
        assertThat(car.position).isEqualTo(0)
    }
}