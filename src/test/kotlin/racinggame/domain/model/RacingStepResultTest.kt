package racinggame.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingStepResultTest {
    private val racingStepResult by lazy {
        RacingStepResult(
            listOf(
                IndividualRacingStepStatus("java", 1),
                IndividualRacingStepStatus("kotlin", 2),
                IndividualRacingStepStatus("javascript", 2)
            )
        )
    }

    @Test
    fun `RacingStepResult는 현재 각 자동차들의 이름과 전진 level을 보관한다`() {
        val expected = listOf(
            IndividualRacingStepStatus("java", 1),
            IndividualRacingStepStatus("kotlin", 2),
            IndividualRacingStepStatus("javascript", 2)
        )
        racingStepResult.racingGameStatusList.forEachIndexed { index, level ->
            assertThat(level).isEqualTo(expected[index])
        }
    }

    @Test
    fun `firstPlaces를 통해 현재 선두로 달리고 있는 자동차들의 이름을 구할 수 있다`() {
        val firstPlaces = racingStepResult.firstPlaces

        assertThat(firstPlaces).isEqualTo(listOf("kotlin", "javascript"))
    }
}
