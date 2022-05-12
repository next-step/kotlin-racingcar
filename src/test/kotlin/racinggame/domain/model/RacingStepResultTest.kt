package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingStepResultTest {
    @Test
    fun `RacingStepResult는 현재 각 자동차들의 이름과 전진 level을 보관한다`() {
        val racingStepResult = RacingStepResult(
            listOf(
                IndividualRacingStepStatus("java", 1),
                IndividualRacingStepStatus("kotlin", 2),
                IndividualRacingStepStatus("javascript", 0)
            )
        )

        val expected = listOf(
            IndividualRacingStepStatus("java", 1),
            IndividualRacingStepStatus("kotlin", 2),
            IndividualRacingStepStatus("javascript", 0)
        )
        racingStepResult.racingGameStatusList.forEachIndexed { index, level ->
            assertThat(level).isEqualTo(expected[index])
        }
    }
}
