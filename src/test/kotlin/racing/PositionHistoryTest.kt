package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.CarMoveResult
import racing.model.Name
import racing.model.Position
import racing.model.PositionHistory

class PositionHistoryTest {
    @Test
    fun `우승자 구하기 테스트`() {
        // given
        val results = mutableListOf<CarMoveResult>()
        repeat(5) {
            results.add(CarMoveResult(Name("Car $it"), Position(it)))
        }
        val positionHistory = PositionHistory(results.toList())

        // when
        val winner = positionHistory.getMaxPositionCarName().names.joinToString { it.name }

        // then
        assertThat(winner).isEqualTo("Car 4")
    }
}
