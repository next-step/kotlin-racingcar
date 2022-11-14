package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    @DisplayName("전진 조건일 경우 자동차의 현재 위치가 1 증가함")
    fun `Increase by 1 if forward`() {
        val cars = Car.registerCars(listOf("홍길동"))
        cars.first().drive(Gear.FORWARD)
        assertThat(cars.first().currentPosition).isEqualTo(1)
    }

    @Test
    @DisplayName("정지 조건일 경우 자동차의 현재 위치 고정")
    fun `Fixed if stop`() {
        val cars = Car.registerCars(listOf("홍길동"))
        cars.first().drive(Gear.STOP)
        assertThat(cars.first().currentPosition).isEqualTo(0)
    }

    @Test
    @DisplayName("A자동차와 B자동차 중 A자동차가 가장 멀리 감")
    fun `Out of cars A and B, car A is the farthest away`() {
        val carA = Car("A", 5)
        val carB = Car("B")

        val cars = listOf(carA, carB)
        val furthestCars = Car.getFurthestCars(cars)

        assertThat(furthestCars.contains(carA)).isTrue
    }
}
