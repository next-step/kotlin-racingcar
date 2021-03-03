package racing.domain.ranking

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racing.ui.RacingCarDto
import racing.ui.RacingCarDtos

internal class RankerTest {
    @DisplayName("CarDto 리스트들을 인자로 받은 경우 우승자 리스트를 반환")
    @Test
    internal fun getWinners() {
        val record = listOf(
            RacingCarDtos(listOf(RacingCarDto("pobi", 0), RacingCarDto("crong", 0))),
            RacingCarDtos(listOf(RacingCarDto("pobi", 1), RacingCarDto("crong", 0)))
        )

        val winners = Ranker().getWinners(record)

        assertThat(winners).isEqualTo(listOf("pobi"))
    }
}