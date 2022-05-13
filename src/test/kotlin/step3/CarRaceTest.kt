package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.car.Car
import step3.common.CarRaceProperty
import step3.race.CarRace

class CarRaceTest {

    @Test
    fun `이동 불가능한 케이스 테스트`() {
        val moveImpossibleCar = Car(0)

        assertThat(moveImpossibleCar.canMoveForward(3)).isEqualTo(false)
    }

    @Test
    fun `이동 가능한 케이스 테스트`() {
        val movePossibleCar = Car(0)

        assertThat(movePossibleCar.canMoveForward(7)).isEqualTo(true)
    }

    @Test
    fun `이동이 되었는지 테스트`() {
        val carSize = 1
        val roundSize = 1
        val carToMove = Car(0)
        val cars = listOf(carToMove)
        val carRaceProperty = CarRaceProperty(roundSize, carSize, cars)

        val carRace = CarRace()
        carRace.moveCarPosition(carToMove)

        assertThat(carRaceProperty.cars[0].moveCount).isEqualTo(1)
    }
}
