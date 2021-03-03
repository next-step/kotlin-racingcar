package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {
    @Test
    fun `차를 한칸 움직인다`() {
        val car = CarFixtures.createAlwaysMovingCar()
        val startPosition = car.position
        car.attemptsMoveForward()
        assertThat(car.position - startPosition).isEqualTo(1)
    }
}
