package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.common.CarRaceProperty
import racing.race.CarRace
import racing.view.ResultView

class CarRaceTest {

    @Test
    fun `이동이 되었는지 테스트`() {
        val roundSize = 1
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        val resultView = ResultView(carRaceProperty)

        val carRace = CarRace(carRaceProperty, resultView)
        carRace.moveCarPosition(carRaceProperty.cars[0])

        assertThat(carRaceProperty.cars[0].getMoveCount()).isEqualTo(1)
    }
}
