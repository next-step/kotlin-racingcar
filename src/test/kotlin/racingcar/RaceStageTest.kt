package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RaceStageTest {

    @Test
    @DisplayName("round 에 음수가 들어가면 예외가 발생한다.")
    internal fun racingRoundNegativeExceptionTest() {
        // when, then
        assertThatIllegalArgumentException().isThrownBy { RaceStage.create(-1) }
        assertThatIllegalArgumentException().isThrownBy { RaceStage(listOf(Car(), Car()), -1) }
    }

    @Test
    @DisplayName("자동차가 갯수가 비어있으면 예외가 발생한다.")
    internal fun racingRoundEmptyCarsExceptionTest() {
        // when, then
        assertThatIllegalArgumentException().isThrownBy { RaceStage(listOf(), 1) }
    }

    @Test
    @DisplayName("자동차가 갯수만큼 생성된다.")
    internal fun createTest() {
        // given

        // when
        val raceStage = RaceStage.create(5)

        // then
        assertThat(raceStage.cars).hasSize(5)
    }

    @Test
    @DisplayName("경주를 하고나면 다음 라운드로 넘어간다.")
    internal fun racingTest() {
        // given
        val raceStage = RaceStage.create(5)

        // when
        val afterRaceStage = raceStage.racing()

        // then
        assertThat(afterRaceStage.round).isEqualTo(1)
    }
}
