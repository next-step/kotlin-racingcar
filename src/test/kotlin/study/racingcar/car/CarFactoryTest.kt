package study.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarFactoryTest {
    @Test
    fun `정해진 갯수의 Car 클래스를 생성할 수 있다`() {
        val cars = CarFactory.createCars(3)
        assertThat(cars.size).isEqualTo(3)
    }
}
