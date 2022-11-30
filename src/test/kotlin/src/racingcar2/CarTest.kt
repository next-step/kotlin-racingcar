package src.racingcar2

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 여러번 생성될 수 있다`() {
        val car1 = Car()
        val car2 = Car()
        val cars = listOf(car1, car2)

        assertThat(cars.size).isEqualTo(2)
    }

    @Test
    fun `자동차는 출발하기 전에 멈추어 있다`() {
        assertThat(Car().position).isEqualTo(0)
    }

    @Test
    fun `자동차는 무작위 값이 4이상일 경우 전진할 수 있다`() {
        assertThat(Car().move(4)).isEqualTo(1)
    }

    @Test
    fun `여러 대의 자동차는 전진할 수 있다`() {
        val car1 = Car()
        val car2 = Car()
        val cars = listOf(car1, car2)

        car1.move(4)
        car2.move(4)

        assertThat(cars[0].position).isEqualTo(1)
        assertThat(cars[1].position).isEqualTo(1)
    }
}