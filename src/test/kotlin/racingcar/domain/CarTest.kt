package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun move() {
        val car = Car(1)

        car.move()

        assertThat(car.position).isEqualTo(1)
    }
}
