package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.domain.MovingDistance
import racingcar.domain.MovingDistance.GO
import racingcar.domain.MovingDistance.MIN_RUN_NUMBER

class MovingDistanceTest {
    @Test
    @DisplayName(value = "4이상이면 전진한다.")
    fun moveDecisionTest() {
        assertThat(MovingDistance.moveDecision(MIN_RUN_NUMBER)).isEqualTo(GO)
    }
}
