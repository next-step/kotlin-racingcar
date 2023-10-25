package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import step3.domain.VisualizeMoveCount

class VisualizeMoveCountTest {
    @Test
    fun `카운트에 따라 -의 개수가 정상적으로 출력된다`() {
        assertThat(VisualizeMoveCount.visualizeMoveCount(4)).isEqualTo("----")
        assertThat(VisualizeMoveCount.visualizeMoveCount(2)).isEqualTo("--")
        assertThat(VisualizeMoveCount.visualizeMoveCount(0)).isEqualTo("")
    }
}
