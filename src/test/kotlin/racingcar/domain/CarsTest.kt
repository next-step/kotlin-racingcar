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
    fun `자동차들은 움직일 수 있다`() {
        val cars = Cars.of(listOf("제이", "제이슨", "포비"))
        cars.move(alwaysMovingStrategy)
        cars.values.forEach { car -> assertThat(car.position.value).isEqualTo(1) }
    }
}
