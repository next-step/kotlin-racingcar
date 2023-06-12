package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.mock.FakeForwardCondition

class WinnerTest {

    @Test
    fun `우승자가 여러 명인 경우`() {
        // given
        val carNames = listOf("carName1", "carName2")
        val attemptCount = 2
        val cars = Cars.of(carNames, FakeForwardCondition(true))
        val racing = Racing(cars, attemptCount)

        // when
        val racingPhasedRecords = racing.start()
        val winners = Winner.getWinners(racingPhasedRecords)

        // then
        assertThat(winners.size).isEqualTo(carNames.size)
    }
}
