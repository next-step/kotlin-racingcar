package step4.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultViewTest {
    @Test
    fun `visualize block test`() {
        val raceResult = ArrayList<Int>()

        raceResult.add(0)
        raceResult.add(1)
        raceResult.add(1)
        raceResult.add(1)
        raceResult.add(0)
        raceResult.add(1)

        assertThat(ResultView.visualize(3, raceResult)).isEqualTo("--")
        assertThat(ResultView.visualize(6, raceResult)).isEqualTo("----")
    }
}
