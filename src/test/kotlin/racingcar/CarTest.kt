package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.domain.Car.Companion.drive
import racingcar.domain.Gear

class CarTest {

    @Test
    @DisplayName("전진 조건일 경우 자동차의 현재 위치가 1 증가함")
    fun `Increase by 1 if forward`() {
        val cars = Car.registerCars(1)
        Gear.FORWARD.range = 0..9
        Gear.STOP.range = -1..-1
        cars.first().drive(RandomGear.getGear())
        assertThat(cars.first().getCurrentPosition()).isEqualTo(1)
    }

    @Test
    @DisplayName("정지 조건일 경우 자동차의 현재 위치 고정")
    fun `Fixed if stop`() {
        val cars = Car.registerCars(1)
        Gear.FORWARD.range = -1..-1
        Gear.STOP.range = 0..9
        cars.first().drive(RandomGear.getGear())
        assertThat(cars.first().getCurrentPosition()).isEqualTo(0)
    }
}
