package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTests {
    @Test
    fun `diceMoveAddStep`() {
        val car = Car("test", 0, Dice())
        var previousStepCount = car.stepList.size
        car.move()
        assertThat(previousStepCount + 1).isEqualTo(car.stepList.size)
    }

    @Test
    fun `carCanHaveANameIn5lengthString`() {
        val name = "hello"
        val car = Car(name, 0, Dice())
        assertThat(car.driverName).isEqualTo(name)
    }

    @Test
    fun `carCanNotHaveANameOver5lengthStringAndThrowException`() {
        val name = "helloworld"
        val car = Car(name, 0, Dice())
        assertThat(car.driverName).isEqualTo(name)
    }
}
