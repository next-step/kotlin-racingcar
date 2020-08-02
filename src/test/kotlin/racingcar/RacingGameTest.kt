package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.RacingGame

class RacingGameTest {

    @Test
    fun `우승자가 한 명인 경우`() {
        val cars = listOf(Car("1st"), Car("2nd"), Car("3rd"))
        val participant = RacingGame(racingCars = cars)
        cars[0].move(4)
        assertThat(participant.findWinner()).isEqualTo(cars[0].name)
    }

    @Test
    fun `우승자가 여러 명인 경우`() {
        val cars = listOf(Car("1st"), Car("2nd"), Car("best"))
        val participant = RacingGame(racingCars = cars)
        cars[0].move(4)
        cars[2].move(4)
        assertThat(participant.findWinner()).isEqualTo(listOf(cars[0].name, cars[2].name).joinToString())
    }
}
