package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.vo.Position
import racing.exception.PositionException

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 5, 11])
    fun `자동차 초기 위치는 0이상인 경우 통과한다`(position: Int) {
        val carPosition = Position(position)
        assertThat(carPosition.value).isEqualTo(position)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -10])
    fun `자동차 초기 위치는 0미만인 경우 실패한다`(position: Int) {
        assertThrows<PositionException> {
            Position(position)
        }
    }
}
