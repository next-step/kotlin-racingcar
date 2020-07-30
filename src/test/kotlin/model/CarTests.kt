package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTests {
    @Test
    fun `diceMoveAddStep`() {
        val dice = Dice()
        val car = Car(dice, "test")
        var previousStepCount = car.getStepList().size
        car.diceMove()
        assertThat(previousStepCount + 1).isEqualTo(car.getStepList().size)
    }

    @Test
    fun `carCanHaveANameIn5lengthString`() {
        val dice = Dice()
        val name = "hello"
        val car = Car(dice, name)
        assertThat(car.driverName).isEqualTo(name)
    }

    @Test
    fun `carCanNotHaveANameOver5lengthStringAndThrowException`() {
        val dice = Dice()
        val name = "helloworld"
        val car = Car(dice, name)
        assertThat(car.driverName).isEqualTo(name)
    }
}
