package racing

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.model.Position
import racing.model.Position.Companion.INVALID_CAR_POSITION

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, -10])
    fun `자동차 위치 에러 테스트`(position: Int) {
        assertThatIllegalArgumentException().isThrownBy {
            Position(position)
        }.withMessage(INVALID_CAR_POSITION)
    }
}
