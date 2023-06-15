package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.mock.FakeForwardCondition

class RacingTest {

    @Test
    fun `start 시 racingPhasedRecords 가 추가된다`() {
        // given
        val carNames = listOf("car1", "car2")
        val attemptCount = 3
        val cars = Cars.of(carNames, FakeForwardCondition(true))
        val racing = Racing(cars)

        // when
        val racingPhaseRecords = racing.start(attemptCount)

        // then
        assertAll({
            assertThat(racingPhaseRecords.size).isEqualTo(attemptCount)
            assertThat(racingPhaseRecords[0].records.size).isEqualTo(carNames.size)
        })
    }
}
