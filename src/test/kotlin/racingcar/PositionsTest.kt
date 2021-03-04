package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PositionsTest {
    @Test
    fun `최대 position 값을 리턴한다`() {
        val positions = Positions(listOf(Position(3), Position(5), Position(9)))

        val maxPosition = positions.max()

        assertThat(maxPosition).isEqualTo(Position(9))
    }
}
