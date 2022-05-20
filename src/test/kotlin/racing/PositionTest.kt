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
    fun `자동차 위치 통과 테스트`(position: Int) {
        val carPosition = Position(position)
        assertThat(carPosition.value).isEqualTo(position)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -10])
    fun `자동차 위치 에러 테스트`(position: Int) {
        assertThrows<PositionException> {
            Position(position)
        }
    }
}
