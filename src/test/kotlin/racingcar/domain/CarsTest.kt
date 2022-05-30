package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.move.MovingStrategy

class CarsTest {
    private val alwaysMovingStrategy = object : MovingStrategy {
        override fun canMove(): Boolean {
            return true
        }
    }
    @Test
    fun `자동차들은 움질일 수 있다`() {
        val cars = Cars(listOf(Car(), Car(), Car()))
        cars.move(alwaysMovingStrategy)
        cars.values.forEach { car -> assertThat(car.position.value).isEqualTo(1) }
    }
}
