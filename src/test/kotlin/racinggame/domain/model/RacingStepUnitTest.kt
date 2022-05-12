package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingStepUnitTest {
    @Test
    fun `RacingStepUnit은 어떤 자동차가 몇 단계까지 전진했는지 상태를 보관한다`() {
        val racingStepUnit = RacingStepUnit("object", 5)

        assertThat(racingStepUnit.name).isEqualTo("object")
        assertThat(racingStepUnit.proceedLevel).isEqualTo(5)
    }
}