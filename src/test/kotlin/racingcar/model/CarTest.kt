package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.strategy.FairMovingStrategy

internal class CarTest {
    private val car = Car(0, "car", FairMovingStrategy())

    @Test
    fun getName() {
        assertThat(car.getName()).isEqualTo("No.0 car")
    }

    @Test
    fun getMovingPath() {
        car.moveForward()
        assertThat(car.getMovingPath()).isEqualTo("-")
    }
}
