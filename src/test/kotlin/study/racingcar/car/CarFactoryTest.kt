package study.racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarFactoryTest {
    @Test
    fun `자동차 이름들을 통해 Car 클래스를 생성할 수 있다`() {
        val names = listOf("소나타", "그렌저", "카니발")
        val cars = CarFactory.createCars(names)

        assertThat(cars.size).isEqualTo(3)
    }
}
