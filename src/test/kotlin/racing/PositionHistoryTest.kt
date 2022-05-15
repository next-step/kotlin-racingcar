package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.model.CarMoveResult
import racing.model.PositionHistory

class PositionHistoryTest {
    private lateinit var positionHistory: PositionHistory

    @BeforeEach
    fun setUp() {
        positionHistory = PositionHistory(mutableListOf())
    }

    @Test
    fun `이동 결과 저장 테스트`() {
        // given
        repeat(10) { position ->
            positionHistory.save(CarMoveResult("차${position}", position))
        }

        // when
        val size = positionHistory.size()

        // then
        assertThat(size).isEqualTo(10)
    }

    @Test
    fun `우승자 구하기 테스트`() {
        // given
        repeat(10) { position ->
            positionHistory.save(CarMoveResult("이름 $position", position))
        }

        // when
        val winner = positionHistory.getMaxPositionCarName().joinToString()

        // then
        assertThat(winner).isEqualTo("이름 9")
    }
}
