package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("전진 조건일 경우 자동차의 현재 위치가 1 증가함")
    fun `Increase by 1 if forward`() {
        val cars = Car.registerCars(1)
        cars.first().drive(Gear.FORWARD)
        assertThat(cars.first().currentPosition).isEqualTo(1)
    }

    @Test
    @DisplayName("정지 조건일 경우 자동차의 현재 위치 고정")
    fun `Fixed if stop`() {
        val cars = Car.registerCars(1)
        cars.first().drive(Gear.STOP)
        assertThat(cars.first().currentPosition).isEqualTo(0)
    }
}
