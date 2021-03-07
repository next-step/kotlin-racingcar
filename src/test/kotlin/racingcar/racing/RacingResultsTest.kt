package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.CarLocation
import racingcar.racing.car.CarName

internal class RacingResultsTest {
    private val dummyRecords = listOf(Record(CarName(""), CarLocation.ZERO))

    @ParameterizedTest
    @ValueSource(ints = [1, 10, 50])
    fun `순서대로 결과가 들어온다면 순서대로 trial을 반환`(numberOfTrials: Int) {
        val shuffledTrials = (1..numberOfTrials).shuffled()
            .map { TrialOrder(it) }
            .map { RacingTrial(it, dummyRecords) }
        val results = RacingResults(shuffledTrials.sortedBy { it.order })
        assertThat(results.trials)
            .hasSize(numberOfTrials)
            .containsExactlyElementsOf(
                (1..numberOfTrials)
                    .map { TrialOrder(it) }
                    .map { RacingTrial(it, dummyRecords) }
            )
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 10, 50])
    fun `trials의 order 값들이 1부터 순서대로 있지 않다면 IllegalArgumentException throw`(numberOfTrials: Int) {
        val trialsWithRandomOrder = (1..numberOfTrials).map { order ->
            RacingTrial(TrialOrder(getRandomNumberWithoutOrderNumber(numberOfTrials, order)), dummyRecords)
        }
        assertThatIllegalArgumentException()
            .isThrownBy { RacingResults(trialsWithRandomOrder) }
            .withMessage("The results of racing is not ordered. trial orders=${trialsWithRandomOrder.map { it.order }}")
    }

    private fun getRandomNumberWithoutOrderNumber(numberOfTrials: Int, exception: Int): Int {
        val randomNumber = (1..numberOfTrials).random()
        if (randomNumber == exception) {
            return getRandomNumberWithoutOrderNumber(numberOfTrials, exception)
        }
        return randomNumber
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

    private fun makeDummy(order: Int, 초반우세: Int, 중반우세: Int, 최종우승: Int) = makeTrial(
        order = order,
        records = listOf(
            "초반우세" to 초반우세,
            "중반우세" to 중반우세,
            "최종우승" to 최종우승
        )
    )

    private fun makeTrial(order: Int, records: List<Pair<String, Int>>) = RacingTrial(
        TrialOrder(order),
        records.map { (name, location) -> Record(CarName(name), CarLocation(location)) }
    )
}
