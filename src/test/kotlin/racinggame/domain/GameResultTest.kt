package racinggame.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameResultTest {
    @Test
    fun `find winners - one winner`() {
        val cars = listOf(RacingCar("first", 6), RacingCar("sec", 3), RacingCar("third", 4))

        val winners = GameResult.findWinners(cars)
        assertThat(winners.size).isEqualTo(1)
        assertThat(winners[0].carName).isEqualTo("first")
    }

    @Test
    fun `find winners - two winners`() {
        val cars = listOf(RacingCar("first", 6), RacingCar("sec", 6), RacingCar("third", 4))
        val winners = GameResult.findWinners(cars)
        assertThat(winners.size).isEqualTo(2)
        assertThat(winners[0].carName).isEqualTo("first")
        assertThat(winners[1].carName).isEqualTo("sec")
    }
}
