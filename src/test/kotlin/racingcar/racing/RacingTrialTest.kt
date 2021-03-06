package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.CarLocation
import racingcar.racing.car.CarName

internal class RacingTrialTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 3, 100, Int.MAX_VALUE])
    fun `order를 넣어 생성한 대로, order를 반환`(order: Int) {
        val trial = RacingTrial(TrialOrder(order), listOf())
        assertThat(trial.order).isEqualTo(TrialOrder(order))
    }

    @Test
    fun `가장 높은 위치 값을 가진 기록들을 반환한다`() {
        val records = listOf(
            Record(CarName("최선두1"), CarLocation(8)),
            Record(CarName("최선두2"), CarLocation(8)),
            Record(CarName("그외1"), CarLocation(7)),
            Record(CarName("그외2"), CarLocation(7)),
            Record(CarName("그외3"), CarLocation(6)),
            Record(CarName("그외4"), CarLocation(4)),
            Record(CarName("그외5"), CarLocation(1)),
            Record(CarName("그외6"), CarLocation(0))
        ).shuffled()
        val trial = RacingTrial(TrialOrder(1), records)
        assertThat(trial.leadRecords).containsAnyOf(
            Record(CarName("최선두1"), CarLocation(8)),
            Record(CarName("최선두2"), CarLocation(8))
        )
    }
}
