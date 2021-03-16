package racingcar.history

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.Car

internal class RacingRoundHistoryTest {
    @Test
    @DisplayName("차들의 현재 위치를 기록한다")
    fun racingAction() {
        val car1 = Car("jyami")
        val car2 = Car("java")
        val round1 = RacingRoundHistory.of(1, listOf(car1, car2))
        car1.tryMove(10)
        val round2 = RacingRoundHistory.of(2, listOf(car1, car2))

        assertThat(round1.racingActionHistories).containsSequence(
            RacingActionHistory(0, "jyami"),
            RacingActionHistory(0, "java")
        )
        assertThat(round2.racingActionHistories).containsSequence(
            RacingActionHistory(1, "jyami"),
            RacingActionHistory(0, "java")
        )
    }
}
