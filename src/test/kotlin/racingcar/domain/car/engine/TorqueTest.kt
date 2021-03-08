package racingcar.domain.car.engine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class TorqueTest {
    @Test
    fun `value는 올바른 값을 가져야 한다`() {
        assertAll(
            { assertThat(Torque.STOP.value).isEqualTo(0) },
            { assertThat(Torque.MOVE.value).isEqualTo(1) }
        )
    }
}
