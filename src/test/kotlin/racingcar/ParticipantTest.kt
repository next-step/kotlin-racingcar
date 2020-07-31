package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Participant

class ParticipantTest {

    @Test
    fun `우승자가 한 명인 경우`() {
        val cars = listOf(Car("1st"), Car("2nd"), Car("3rd"))
        val participant = Participant(racingCars = cars, tryCount = 1)
        cars[0].move(4)
        assertThat(participant.findWinner()).isEqualTo(cars[0])
    }
}
