package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PositionTest {
    @Test
    internal fun `위치값 증가`() {
        val position = Position()
        position.increase()
        assertThat(position.value).isEqualTo(2)
    }
}
