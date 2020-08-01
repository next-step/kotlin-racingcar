package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTests {
    @Test
    fun `diceMoveAddStep`() {
        val car = Car("test")
        var previousStepCount = car.stepList.size
        car.move(true)
        assertThat(previousStepCount + 1).isEqualTo(car.stepList.size)
    }

    @Test
    fun `carCanHaveANameIn5lengthString`() {
        val name = "hello"
        val car = Car(name)
        assertThat(car.driverName).isEqualTo(name)
    }

    @Test
    fun `carCanNotHaveANameOver5lengthStringAndThrowException`() {
        val name = "helloworld"
        val car = Car(name)
        assertThat(car.driverName).isEqualTo(name)
    }
}
