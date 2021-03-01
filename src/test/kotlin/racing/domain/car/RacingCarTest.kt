package racing.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racing.domain.movement.GoForwardMoveStrategy
import racing.domain.movement.StopMoveStrategy

internal class RacingCarTest {
    @DisplayName("4 이상의 숫자가 나온 경우 전진")
    @Test
    internal fun move_goForward() {
        val racingCar = RacingCar()
        val moveStrategy = GoForwardMoveStrategy()

        assertThat(racingCar.move(moveStrategy)).isEqualTo(1)
    }

    @DisplayName("3 이하의 숫자가 나온 경우 정지")
    @Test
    internal fun move_stop() {
        val racingCar = RacingCar()
        val moveStrategy = StopMoveStrategy()

        assertThat(racingCar.move(moveStrategy)).isEqualTo(0)
    }
}
