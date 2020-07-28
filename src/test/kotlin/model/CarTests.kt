package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTests {
    @Test
    fun `diceMoveAddStep`() {
        val dice = Dice()
        val car = Car(dice)
        var previousStepCount = car.getStepList().size
        car.diceMove()
        assertThat(previousStepCount + 1).isEqualTo(car.getStepList().size)
    }
}
