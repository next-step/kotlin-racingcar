package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.Car
import racing.common.CarRaceProperty
import racing.race.CarRace

class CarRaceTest {

    @Test
    fun `이동 불가능한 케이스 테스트`() {
        val moveImpossibleCar = Car("A", 0)

        assertThat(moveImpossibleCar.canMoveForward(3)).isEqualTo(false)
    }

    @Test
    fun `이동 가능한 케이스 테스트`() {
        val movePossibleCar = Car("A", 0)

        assertThat(movePossibleCar.canMoveForward(7)).isEqualTo(true)
    }

    @Test
    fun `이동이 되었는지 테스트`() {
        val carSize = 1
        val roundSize = 1
        val carToMove = Car("A", 0)
        val cars = listOf(carToMove)
        val carRaceProperty = CarRaceProperty(roundSize, cars)

        val carRace = CarRace()
        carRace.moveCarPosition(carToMove)

        assertThat(carRaceProperty.cars[0].getMoveCount()).isEqualTo(1)
    }
}
