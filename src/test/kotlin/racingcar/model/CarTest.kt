package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun run() {
        val car = Car(name = "myCar")
        car.stepForward(true)
        assertThat(car.position).isEqualTo(1)
    }
}
