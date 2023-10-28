package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarRaceTest {

    @Test
    fun `자동차 경주 게임 테스트`() {
        val carRace = CarRace(3)
        val carsPosition = carRace.getCarStatus()
        assertThat(carsPosition).isEqualTo(listOf(1, 1, 1))
        assertThat(carsPosition.size).isEqualTo(3)
    }
}
