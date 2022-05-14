package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racing.model.PositionHistory

class PositionHistoryTest {
    private lateinit var positionHistory: PositionHistory

    @BeforeEach
    fun setUp() {
        positionHistory = PositionHistory(mutableListOf())
    }

    @Test
    fun `위치 저장 테스트`() {
        // given
        repeat(10) { position ->
            positionHistory.save(position)
        }

        // when
        val size = positionHistory.size()

        // then
        assertThat(size).isEqualTo(10)
    }

    @Test
    fun `위치 조회 테스트`() {
        // given
        repeat(10) { position ->
            positionHistory.save(position)
        }

        // when
        val position = positionHistory.getPosition(5)

        // then
        assertThat(position).isEqualTo(5)
    }
}
