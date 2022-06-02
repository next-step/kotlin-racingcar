package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun move() {
        val car = Car("dd.kim")

        car.move()

        assertThat(car.position).isEqualTo(1)
    }
}
