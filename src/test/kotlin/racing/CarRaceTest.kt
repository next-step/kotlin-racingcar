package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.common.CarRaceProperty
import racing.race.CarRace

class CarRaceTest {

    @Test
    fun `이동이 되었는지 테스트`() {
        val roundSize = 1
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)

        val carRace = CarRace(carRaceProperty)
        carRace.moveCarPosition(carRaceProperty.cars[0])

        assertThat(carRaceProperty.cars[0].getMoveCount()).isEqualTo(1)
    }
}
