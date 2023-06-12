package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racing.domain.Cars
import racing.domain.Racing
import racing.mock.FakeForwardCondition

class RacingTest {

    @Test
    fun `start 시 racingPhasedRecords 가 추가된다`() {
        // given
        val carNames = listOf("carName1", "carName2")
        val attemptCount = 3
        val cars = Cars.of(carNames, FakeForwardCondition(true))
        val racing = Racing(cars, attemptCount)

        // when
        val racingPhasedRecords = racing.start()

        // then
        assertAll({
            assertThat(racingPhasedRecords.size).isEqualTo(attemptCount)
            assertThat(racingPhasedRecords[0].records.size).isEqualTo(carNames.size)
        })
    }
}
