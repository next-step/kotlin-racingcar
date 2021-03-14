package racingcar.domain.engine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class TorqueTest {
    @Test
    fun `STOP은 정수 0 값을 가지고, MOVE는 정수 1 값을 가진다`() {
        assertAll(
            { assertThat(Torque.STOP.value).isEqualTo(0) },
            { assertThat(Torque.MOVE.value).isEqualTo(1) }
        )
    }
}
