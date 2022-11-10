package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PositionTest {
    @Test
    internal fun `위치값 증가`() {
        val customSpeed = 6
        val customPosition = Position(4)
        customPosition.increase(customSpeed)
        assertThat(customPosition.value).isEqualTo(10)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1])
    internal fun `1보다 작은 위치 생성불가`(value: Int) {
        assertThrows<IllegalArgumentException> { Position(value) }
    }
}
