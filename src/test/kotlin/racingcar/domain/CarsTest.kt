package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {
    @Test
    fun `자동차들은 움질일 수 있다`() {
        val cars = Cars(listOf(Car(), Car(), Car()))
        cars.move { true }
        cars.values.forEach { car -> assertThat(car.position.value).isEqualTo(1) }
    }
}
