package racingcar.domain.car.vo

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1])
    fun `포지션 생성`(value: Int) {
        val position = Position(value)
        assertThat(position.value).isEqualTo(value)
    }

    @Test
    fun `포지션 생성 예외`() {
        assertThatThrownBy { Position(-1) }
            .isInstanceOf(IllegalArgumentException().javaClass)
    }

    @Test
    fun `포지션 전진`() {
        val position = Position()
        position.move()

        assertThat(position.value).isEqualTo(1)
    }
}
