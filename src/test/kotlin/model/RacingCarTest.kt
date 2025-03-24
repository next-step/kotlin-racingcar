package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {
    @Test
    fun `car is not moving when generated number is 3`() {
        val racingCar = RacingCar(moved = 2, generator = { 3 }, "Anna")
        racingCar.moveRandomly()
        assertThat(racingCar.getCurrentState()).isEqualTo(2)
    }

    @Test
    fun `car is moving when generated number is 5`() {
        val racingCar = RacingCar(moved = 3, generator = { 5 }, "Anna")
        racingCar.moveRandomly()
        assertThat(racingCar.getCurrentState()).isEqualTo(4)
    }
}
