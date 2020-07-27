package step3.view

import org.assertj.core.api.AssertionsForInterfaceTypes
import org.junit.jupiter.api.Test

class ResultViewTest {
    @Test
    fun `visualize block test`() {
        AssertionsForInterfaceTypes.assertThat(ResultView.visualize(5)).isEqualTo("-----")
    }
}
