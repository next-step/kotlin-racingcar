package racingcar.history

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import racingcar.domain.Car

internal class RacingResultHistoryTest {

    @Test
    @DisplayName("자동차의 위치를 logging 하여 history를 저장한다.")
    fun logging() {
        val racingResultHistory = RacingResultHistory()
        val car1 = Car()
        val car2 = Car()
        racingResultHistory.logging(1, listOf(car1, car2))
        car2.tryMove(10)
        racingResultHistory.logging(2, listOf(car1, car2))

        assertThat(racingResultHistory.getResults()[0].racingActionHistories)
            .containsSequence(RacingActionHistory(0), RacingActionHistory(0))
        assertThat(racingResultHistory.getResults()[1].racingActionHistories)
            .containsSequence(RacingActionHistory(0), RacingActionHistory(1))
    }
}
