package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class IndividualRacingStepStatusTest {
    @Test
    fun `IndividualRacingStepStatus는 어떤 자동차가 몇 단계까지 전진했는지 상태를 보관한다`() {
        val individualRacingStepStatus = IndividualRacingStepStatus("object", 5)

        assertThat(individualRacingStepStatus.name).isEqualTo("object")
        assertThat(individualRacingStepStatus.proceedLevel).isEqualTo(5)
    }
}
