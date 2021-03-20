package racingcar.history

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import racingcar.domain.Car

internal class RacingActionHistoryTest {

    @Test
    @DisplayName("현재 차의 위치를 RacingAction 으로 저장한다.")
    fun getPosition() {
        val car = Car("mj")

        val action1 = RacingActionHistory.of(car)
        car.tryMove(10)
        val action2 = RacingActionHistory.of(car)

        assertThat(action1.position).isEqualTo(0)
        assertThat(action2.position).isEqualTo(1)
        assertThat(action1.userName).isEqualTo("mj")
        assertThat(action2.userName).isEqualTo("mj")
    }
}
