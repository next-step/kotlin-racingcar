package racingcar.domain.turn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import racingcar.domain.TurnManager
import racingcar.domain.rule.MockUpRule

class TurnManagerTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 10])
    fun `startRaceUntilFinish() 최종 시행 횟수 만큼 누적된 결과의 갯수가 늘어남`(number: Int) {
        val manager = TurnManager(
            number,
            cars = listOf(Car("MOCK")), rule = MockUpRule()
        )
        var results = manager.startRaceUntilFinish()
        assertThat(results).hasSize(number)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 10])
    fun `startRaceUntilFinish() 최종 시행 횟수 만큼 자동차가 움직`(number: Int) {
        val manager = TurnManager(
            number,
            cars = listOf(Car("MOCK")), rule = MockUpRule()
        )
        var results = manager.startRaceUntilFinish()
        results.last().cars.forEach {
            assertThat(it.distance).isEqualTo(number)
        }
    }
}
