package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingStepResultTest {
    @Test
    fun `RacingStepResult는 현재 각 자동차들의 전진 level을 보관한다`() {
        val racingStepResult = RacingStepResult(listOf(1, 2, 0))

        val expected = listOf(1, 2, 0)
        racingStepResult.proceedLevels.forEachIndexed { index, level ->
            assertThat(level).isEqualTo(expected[index])
        }
    }
}
