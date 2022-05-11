package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

internal class CarTest {

    @Test
    fun `차가 한 칸 이동한다`() {
        val car = Car(id = 0)
        val movedCar = car.moveForward { true }
        assertThat(movedCar.position).isEqualTo(1)
    }

    @Test
    fun `차가 한 칸 이동하지 않고 정지한다`() {
        val car = Car(id = 1)
        val notMovedCar = car.moveForward { false }
        assertThat(notMovedCar.position).isEqualTo(0)
    }
}
