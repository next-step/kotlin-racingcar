package com.nextstep.jngcii.racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarTest {

    @Test
    fun `car 생성 실패 테스트`() {
        assertThrows<IllegalArgumentException>("자동차이름은 공백일 수 없습니다.") { Car(" ") }
        assertThrows<IllegalArgumentException>("자동차이름은 5자를 초과할 수 없습니다.") { Car("asdfasd") }
    }

    @ParameterizedTest
    @CsvSource(
        "true, 0, 1",
        "false, 0, 0"
    )
    fun `goOrStayByDiceCondition 실행시 주사위에 따라서 거리가 어떻게 변했는지 테스트`(
        diceCondition: Boolean,
        initialDistance: Int,
        expectedDistance: Int
    ) {
        val car = Car(name = SAMPLE_CAR_NAME, dice = { diceCondition })

        assertThat(car.distance).isEqualTo(initialDistance)

        car.goOrStayByDiceCondition()

        assertThat(car.distance).isEqualTo(expectedDistance)
    }

    companion object {
        private const val SAMPLE_CAR_NAME = "peter"
    }
}
