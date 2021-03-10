package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.CarLocation
import racingcar.domain.car.CarName

internal class RacingTrialTest {
    private val dummyRecord = Record(CarName("dummy"), CarLocation.ZERO)

    @ParameterizedTest
    @ValueSource(ints = [1, 3, 100, Int.MAX_VALUE])
    fun `order를 넣어 생성한 대로, order를 반환`(order: Int) {
        val trial = RacingTrial(TrialOrder(order), listOf(dummyRecord))
        assertThat(trial.order).isEqualTo(TrialOrder(order))
    }

    @Test
    fun `생성할 때, 빈 레코드를 주면 IllegalArgumentException throw`() {
        assertThatIllegalArgumentException()
            .isThrownBy { RacingTrial(TrialOrder(1), listOf()) }
            .withMessage("records is empty!")
    }

    @Test
    fun `가장 높은 위치 값을 가진 기록들을 반환한다`() {
        val records = listOf(
            Record("그외1", location = 6),
            Record("그외2", location = 7),
            Record("최선두2", location = 8),
            Record("그외3", location = 6),
            Record("그외4", location = 0),
            Record("그외5", location = 1),
            Record("최선두1", location = 8),
            Record("그외6", location = 4)
        )
        val trial = RacingTrial(TrialOrder(1), records)
        assertThat(trial.leadRecords).containsAnyOf(
            Record("최선두1", location = 8),
            Record("최선두2", location = 8)
        )
    }
}
