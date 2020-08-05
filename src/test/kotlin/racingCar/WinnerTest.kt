package racingCar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.domain.RacingCars

class WinnerTest {

    @Test
    fun `get winner`() {
        val carNames = listOf<String>("A", "B", "C")
        val racing = RacingCars(carNames)
        RacingCars.participant[0].distance = 3
        assertThat(racing.getRacingWinner(RacingCars.participant)).isEqualTo(RacingCars.participant[0].name)
    }
}
