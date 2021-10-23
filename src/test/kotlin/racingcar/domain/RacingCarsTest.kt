package racingcar.domain

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import racingcar.fixture.RacingCarFixture
import racingcar.fixture.RacingCarsFixture

class RacingCarsTest {

    @Test
    fun `참가자(경주용 자동차)는 1명 미만일 수 없다`() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { RacingCars(listOf()) }
    }

    @Test
    fun `참가자(경주용 자동차)들은 경주할 수 있다`() {
        val participants = RacingCarsFixture.RACING_CARS
        val movedParticipants = participants.race()

        assertThat(participants).isNotEqualTo(movedParticipants)
        assertThat(participants.values).contains(RacingCarFixture.MOVABLE_RACING_CAR, RacingCarFixture.IMMOVABLE_RACING_CAR)
        assertThat(movedParticipants.values).contains(RacingCarFixture.MOVABLE_RACING_CAR.move(), RacingCarFixture.IMMOVABLE_RACING_CAR.move())
    }
}
