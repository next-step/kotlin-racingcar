package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RaceStageTest {

    @Test
    @DisplayName("자동차가 갯수가 비어있으면 예외가 발생한다.")
    internal fun racingRoundEmptyCarsExceptionTest() {
        // when, then
        assertThatIllegalArgumentException().isThrownBy { RaceStage(listOf()) }
    }

    @Test
    @DisplayName("자동차가 갯수만큼 생성된다.")
    internal fun createTest() {
        // given
        val carCount = 5

        // when
        val raceStage = RaceStage.create(carCount)

        // then
        assertThat(raceStage.cars).hasSize(carCount)
    }
}
