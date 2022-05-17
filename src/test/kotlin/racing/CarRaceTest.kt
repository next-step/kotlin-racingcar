package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.car.Car
import racing.common.CarRaceProperty
import racing.race.CarRace

class CarRaceTest {

    @Test
    fun `이동이 되었는지 테스트`() {
        val roundSize = 1
        val carToMove = Car("A", 0)
        val cars = listOf(carToMove)
        val carRaceProperty = CarRaceProperty(roundSize, cars)

        val carRace = CarRace()
        carRace.moveCarPosition(carToMove)

        assertThat(carRaceProperty.cars[0].getMoveCount()).isEqualTo(1)
    }
}
