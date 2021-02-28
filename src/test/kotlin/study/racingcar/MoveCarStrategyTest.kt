package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MoveCarStrategyTest {

    @Test
    fun `0의 위치일때 움질일 수 없다`() {
        val moveStrategy = MoveCarStrategy()
        assertThat(moveStrategy.isMoveCar(0)).isEqualTo(false)
    }

    @Test
    fun `4의 위치일때 움직일 수 있다`() {
        val moveStrategy = MoveCarStrategy()
        assertThat(moveStrategy.isMoveCar(4)).isEqualTo(true)
    }

    @Test
    fun `9의 위치일 때 움직일 수 있다`() {
        val moveStrategy = MoveCarStrategy()
        assertThat(moveStrategy.isMoveCar(9)).isEqualTo(true)
    }
}
