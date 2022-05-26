package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `car 생성 실패 테스트`() {
        assertThrows<IllegalArgumentException>("자동차이름은 공백일 수 없습니다.") { Car(" ") }
        assertThrows<IllegalArgumentException>("자동차이름은 5자를 초과할 수 없습니다.") { Car("asdfasd") }
    }

    @Test
    fun goTest() {
        val car = Car(name = SAMPLE_CAR_NAME, dice = { true })

        assertThat(car.distance).isEqualTo(0)

        car.goOrStayByDiceCondition()

        assertThat(car.distance).isEqualTo(1)
    }

    @Test
    fun notGoTest() {
        val car = Car(name = SAMPLE_CAR_NAME, dice = { false })

        assertThat(car.distance).isEqualTo(0)

        car.goOrStayByDiceCondition()

        assertThat(car.distance).isEqualTo(0)
    }

    companion object {
        private const val SAMPLE_CAR_NAME = "peter"
    }
}
