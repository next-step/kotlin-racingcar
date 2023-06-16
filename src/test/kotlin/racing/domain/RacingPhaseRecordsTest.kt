package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.mock.FakeForwardCondition

class RacingPhaseRecordsTest {

    @Test
    fun `우승자가 여러 명인 경우`() {
        // given
        val carNames = listOf("car1", "car2")
        val attemptCount = 2
        val cars = Cars.of(carNames, FakeForwardCondition(true))
        val racing = Racing(cars)

        // when
        val racingPhaseRecords = racing.start(attemptCount)
        val winners = racingPhaseRecords.last().getWinners()

        // then
        assertThat(winners.size).isEqualTo(carNames.size)
    }
}
