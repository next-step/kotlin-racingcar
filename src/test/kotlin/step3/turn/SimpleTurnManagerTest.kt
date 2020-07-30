package step3.turn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step3.racing.car.Car
import step3.racing.rule.MockUpRule

class SimpleTurnManagerTest {
    @Test
    fun `isFinishOrProceed() 끝나지 않았으면 nextTurn호출하고 false 반환`() {
        val rule = MockUpRule()
        val turn = Turn(cars = listOf(Car("MOCK")), rule = rule)
        val manager = SimpleTurnManager(10, turn)
        assertThat(manager.isFinishOrProceed()).isNotNull()
        assertThat(rule.hasBeenCalled).isTrue()
    }

    @Test
    fun `isFinishOrProceed() 끝났으면 nextTurn호출하지 않고 true 반환`() {
        val rule = MockUpRule()
        val turn = Turn(cars = listOf(Car("MOCK")), rule = rule)
        val manager = SimpleTurnManager(0, turn)
        assertThat(manager.isFinishOrProceed()).isNull()
        assertThat(rule.hasBeenCalled).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `isFinish() turn이 실행된 횟수가 totalStep보다 작으면 false`(number: Int) {
        val manager = SimpleTurnManager(
            10,
            Turn(cars = listOf(Car("MOCK")), rule = MockUpRule())
        )
        assertThat(manager.isFinish()).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19])
    fun `isFinish() turn이 실행된 횟수가 totalStep보다 크거나 같으면 True`(number: Int) {
        val manager = SimpleTurnManager(
            10,
            Turn(
                current = number,
                cars = listOf(Car("MOCK")),
                rule = MockUpRule()
            )
        )
        assertThat(manager.isFinish()).isTrue()
    }
}
