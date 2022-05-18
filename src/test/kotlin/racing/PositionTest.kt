package racing

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.exception.PositionException
import racing.model.Position

class PositionTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, -10])
    fun `자동차 위치 에러 테스트`(position: Int) {
        assertThrows<PositionException> {
            Position(position)
        }
    }
}
