package racingcar.domain.turn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.Car
import racingcar.domain.result.RacingResult
import racingcar.domain.rule.MockUpRule

class TurnManagerTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 10])
    fun `nextTurn() 다음 스텝 진행 시 누적된 결과의 갯수가 늘어남`(number: Int) {
        val manager = TurnManager(
            10,
            cars = listOf(Car("MOCK")), rule = MockUpRule()
        )
        var results = listOf<RacingResult>()
        repeat(number) {
            results = manager.nextTurn()
        }
        assertThat(results).hasSize(number)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 10])
    fun `nextTurn() 다음 스텝 진행 시 누적된 횟수만큼 자동차가 움직`(number: Int) {
        val manager = TurnManager(
            10,
            cars = listOf(Car("MOCK")), rule = MockUpRule()
        )
        var results = listOf<RacingResult>()
        repeat(number) {
            results = manager.nextTurn()
        }
        results.last().cars.forEach {
            assertThat(it.distance).isEqualTo(number)
        }
    }
}
