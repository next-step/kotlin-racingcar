package racingCar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingCar.domain.Car
import racingCar.domain.Winner

class RacingTest {

    @Test
    fun `우승자가 없을 경우`() {
        val participants = listOf<Car>(Car("A", 0))
        val winner = Winner.getRacingWinner(participants)

        Assertions.assertThat(winner).isEqualTo("")
    }

    @Test
    fun `우승자가 1명인 경우`() {
        val participants = listOf<Car>(Car("A", 3), Car("B", 1))
        val winner = Winner.getRacingWinner(participants)

        Assertions.assertThat(winner).isEqualTo("A")
    }

    @Test
    fun `우승자가 2명이상인 경우`() {
        val participants = listOf<Car>(Car("A", 5), Car("B", 5))
        val winner = Winner.getRacingWinner(participants)
        Assertions.assertThat(winner).isEqualTo("A, B")
    }
}
