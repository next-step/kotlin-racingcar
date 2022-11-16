package racingcar.domain

import fixture.TestCarMoveStrategy
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
    @DisplayName("입력받은 자동차 이름 수의 자동차 갯수가 생성된다.")
    internal fun createTest() {
        // given
        val inputCarNames = "pobi,crong,honux".split(",")

        // when
        val raceStage = RaceStage.create(inputCarNames)

        // then
        assertThat(raceStage.cars).hasSize(inputCarNames.size)
    }

    @Test
    @DisplayName("참가한 모든 자동차가 전진한다.")
    internal fun raceForwardTest() {
        // given
        val raceStage = RaceStage.create(listOf("pobi", "crong", "honux"))

        // when
        val result = raceStage.racing(TestCarMoveStrategy(5))

        // then
        assertThat(result.cars).extracting("pos").containsExactlyElementsOf(listOf(1, 1, 1))
    }

    @Test
    @DisplayName("참가한 모든 자동차가 전진하지 않는다.")
    internal fun raceNonForwardTest() {
        // given
        val raceStage = RaceStage.create(listOf("pobi", "crong", "honux"))

        // when
        val result = raceStage.racing(TestCarMoveStrategy(2))

        // then
        assertThat(result.cars).extracting("pos").containsExactlyElementsOf(listOf(0, 0, 0))
    }

    @Test
    @DisplayName("경주 우승자를 정상적으로 반환한다.")
    internal fun getWinnerTest() {
        // given
        val winnerPos = 10
        val raceStage = RaceStage(listOf(Car("a", winnerPos), Car("b", 5), Car("c", 1), Car("d", winnerPos)))

        // when
        val winners = raceStage.getWinners()

        // then
        assertThat(winners).extracting("name").containsExactlyElementsOf(listOf("a", "d"))
    }
}
