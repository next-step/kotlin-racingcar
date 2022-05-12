package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameResultTest {
    private val racingStepResults by lazy {
        listOf(
            RacingStepResult(
                listOf(
                    IndividualRacingStepStatus("dog", 1),
                    IndividualRacingStepStatus("cat", 0),
                    IndividualRacingStepStatus("fox", 0)
                )
            ),
            RacingStepResult(
                listOf(
                    IndividualRacingStepStatus("dog", 1),
                    IndividualRacingStepStatus("cat", 1),
                    IndividualRacingStepStatus("fox", 0)
                )
            )
        )
    }

    private val racingGameResult by lazy {
        RacingGameResult(racingStepResults)
    }

    @Test
    fun `RacingGameResult는 레이싱 게임의 각 단계별 결과를 모두 보관한다`() {
        assertThat(racingGameResult.stepResults).isEqualTo(racingStepResults)
    }
}