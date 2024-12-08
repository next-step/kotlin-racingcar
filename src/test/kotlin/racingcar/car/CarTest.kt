package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `차가 움직인다`() {
        var firstCar = Car()
        firstCar.move(TestMachine.getNumberOne())

        assertThat(firstCar.point).isEqualTo(TestMachine.getNumberOne())
    }
}
