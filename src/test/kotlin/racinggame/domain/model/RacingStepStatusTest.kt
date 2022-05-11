package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingStepStatusTest {
    @Test
    fun `RacingStepStatus는 현재 각 자동차들의 전진 level을 보관한다`() {
        val racingStepStatus = RacingStepStatus(listOf(1, 2, 0))

        val expected = listOf(1, 2, 0)
        racingStepStatus.proceedLevels.forEachIndexed { index, level ->
            assertThat(level).isEqualTo(expected[index])
        }
    }
}
