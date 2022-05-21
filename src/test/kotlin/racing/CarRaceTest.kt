package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.common.CarRaceProperty

class CarRaceTest {

    @Test
    fun `이동이 되었는지 테스트`() {
        val roundSize = 1
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)

        carRaceProperty.cars[0].moveForward()

        assertThat(carRaceProperty.cars[0].getMoveCount()).isEqualTo(1)
    }
}
