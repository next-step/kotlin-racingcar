package week1.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import week1.racing.domain.RacingCar

class RacingCarTest {
    // 전진하는 경우
    @Test
    fun `{given} RacingCar currenPosition = 1, shouldMove = true {when} moveForward() {then} currenPosition == 2`() {
        val racingCar =
            RacingCar(name = "", carMovementDecider = {
                // shouldMove() =
                true
            })
        assertThat(racingCar.currentPosition).isEqualTo(1)
        racingCar.moveForward()
        assertThat(racingCar.currentPosition).isEqualTo(2)
    }

    // 전진하지 않는 경우
    @Test
    fun `{given} RacingCar currenPosition = 1, shouldMove = false {when} moveForward() currenPosition == 1`() {
        val racingCar =
            RacingCar(name = "", carMovementDecider = {
                // shouldMove() =
                false
            })
        assertThat(racingCar.currentPosition).isEqualTo(1)
        racingCar.moveForward()
        assertThat(racingCar.currentPosition).isEqualTo(1)
    }

    @Test
    fun `{given} carName length longer than 5 {when} RacingCar constructor() {then} throws IllegalArgumentException`() {
        assertThrows<IllegalArgumentException> {
            RacingCar(name = "123456", carMovementDecider = { false })
        }
    }
}
