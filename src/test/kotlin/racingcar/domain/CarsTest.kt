package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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

    @Test
    fun `중복된 이름의 자동차는 생성할 수 없다`() {
        assertThatThrownBy { Cars.of(listOf("제이", "제이", "제이슨")) }
            .isInstanceOf(IllegalArgumentException().javaClass)
    }

    @Test
    fun `자동차들은 최소 2대 이상의 차가 생성되어야 함`() {
        assertThatThrownBy { Cars.of(listOf("제이")) }
            .isInstanceOf(IllegalArgumentException().javaClass)
    }
}
