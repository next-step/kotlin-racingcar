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
        val car1 = Car("jyami")
        val car2 = Car("java")
        racingResultHistory.logging(1, listOf(car1, car2))
        car2.tryMove(10)
        racingResultHistory.logging(2, listOf(car1, car2))

        assertThat(racingResultHistory.getResults()[0].racingActionHistories)
            .containsSequence(
                RacingActionHistory(0, "jyami"),
                RacingActionHistory(0, "java")
            )

        assertThat(racingResultHistory.getResults()[1].racingActionHistories)
            .containsSequence(
                RacingActionHistory(0, "jyami"),
                RacingActionHistory(1, "java")
            )
    }
}
