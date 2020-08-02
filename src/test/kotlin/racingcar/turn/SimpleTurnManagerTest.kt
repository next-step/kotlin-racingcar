package racingcar.turn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.Car
import racingcar.racing.result.RacingResult
import racingcar.racing.rule.MockUpRule

class SimpleTurnManagerTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 10])
    fun `nextTurn() 다음 스텝 진행 시 누적된 결과의 갯수가 늘어남`(number: Int) {
        val manager = SimpleTurnManager(
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
        val manager = SimpleTurnManager(
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

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 10])
    fun `startRaceUntilFinish() 실행 시 모두 finish`(number: Int) {
        val manager = SimpleTurnManager(
            number,
            cars = listOf(Car("MOCK")), rule = MockUpRule()
        )
        manager.startRaceUntilFinish()

        assertThat(manager.isFinish()).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `isFinish() turn이 실행된 횟수가 totalStep보다 작으면 false`(number: Int) {
        val manager = SimpleTurnManager(
            10,
            cars = listOf(Car("MOCK")), rule = MockUpRule()
        )
        assertThat(manager.isFinish()).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19])
    fun `isFinish() turn이 실행된 횟수가 totalStep보다 크거나 같으면 True`(number: Int) {
        val manager = SimpleTurnManager(
            10,
            cars = listOf(Car("MOCK")),
            rule = MockUpRule()
        )
        repeat(number) { manager.nextTurn() }

        assertThat(manager.isFinish()).isTrue()
    }
}
