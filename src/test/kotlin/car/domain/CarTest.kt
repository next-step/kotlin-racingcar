package car.domain

import car.domain.Car.Companion.INIT_POSITION
import car.domain.move.AlwaysMovableStrategy
import car.domain.move.AlwaysNotMovableStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `moveable 이 false면은 자동차는 움직이면 안된다`() {
        // given
        val car = Car(carName = "오길환", movableStrategy = AlwaysNotMovableStrategy())

        // when
        car.move()

        // then
        assertThat(car.position)
            .isEqualTo(INIT_POSITION)
    }

    @Test
    fun `moveable 이 true면은 자동차는 움직여도 된다`() {
        // given
        val car = Car(carName = "오길환", movableStrategy = AlwaysMovableStrategy())

        // when
        car.move()

        // then
        assertThat(car.position)
            .isEqualTo(INIT_POSITION + 1)
    }
}
