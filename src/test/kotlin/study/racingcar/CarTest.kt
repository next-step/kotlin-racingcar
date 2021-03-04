package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import study.racingcar.domain.Car

internal class CarTest {

    @Test
    fun `자동차를 움직인다`() {
        val car = Car("test")
        val oldDistance = car.distance
        car.moveCar()
        assertThat(oldDistance).isNotEqualTo(car.distance)
    }

    @Test
    fun `자동차의 이름이 5자 일 경우 자동차가 생성된다`() {
        val car = Car.newCar("abcde")
        assertThat(car.name.isNotEmpty()).isEqualTo(true)
    }

    @Test
    fun `자동차 이름이 6자 일경우 자동차가 생성되지 않는다`() {
        assertThatThrownBy {
            Car.newCar("abcdef")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
