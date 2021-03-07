package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.CarLocation
import racingcar.racing.car.CarName

internal class RacingResultsTest {
    private val dummyRecords = listOf(Record(CarName(""), CarLocation.ZERO))

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 50])
    fun `들어온 trial의 순서와 상관없이 order 순서대로 trial을 반환`(numberOfTrials: Int) {
        val orderedTrials = (1..numberOfTrials).map { RacingTrial(TrialOrder(it), dummyRecords) }

        assertThat(RacingResults(orderedTrials.shuffled()).trials)
            .containsExactlyElementsOf((1..numberOfTrials).map { RacingTrial(TrialOrder(it), dummyRecords) })
    }

    @Test
    fun `마지막 trial의 leadRecords를 가져온다`() {
        val results = RacingResults(
            listOf(
                makeDummy(order = 1, 초반우세 = 1, 중반우세 = 0, 최종우승 = 0),
                makeDummy(order = 2, 초반우세 = 1, 중반우세 = 1, 최종우승 = 1),
                makeDummy(order = 3, 초반우세 = 1, 중반우세 = 2, 최종우승 = 1),
                makeDummy(order = 4, 초반우세 = 1, 중반우세 = 2, 최종우승 = 2),
                makeDummy(order = 5, 초반우세 = 1, 중반우세 = 2, 최종우승 = 3)
            )
        )
        assertThat(results.winnerRecords)
            .containsExactly(Record(CarName("최종우승"), CarLocation(3)))
    }

    private fun makeDummy(order: Int, 초반우세: Int, 중반우세: Int, 최종우승: Int) = RacingTrial(
        TrialOrder(order),
        listOf(
            Record(CarName("초반우세"), CarLocation(초반우세)),
            Record(CarName("중반우세"), CarLocation(중반우세)),
            Record(CarName("최종우승"), CarLocation(최종우승))
        )
    )
}
