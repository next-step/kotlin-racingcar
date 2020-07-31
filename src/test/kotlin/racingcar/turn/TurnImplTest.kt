package racingcar.turn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.Car
import racingcar.racing.rule.MockUpRule

class TurnImplTest {
    @Test
    fun `current 초기값이 0`() {
        assertThat(Turn(cars = listOf(), rule = MockUpRule()).current).isEqualTo(0)
    }

    @Test
    fun `nextTurn()이 doEachTurn을 매번 호출`() {
        val rule = MockUpRule()
        val turn = Turn(cars = listOf(Car("a")), rule = rule)
        turn.nextTurn()
        assertThat(rule.hasBeenCalled).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 10])
    fun `nextTurn()이 호출될 때 마다 current 증가`(number: Int) {
        var turn = Turn(cars = listOf(), rule = MockUpRule())
        repeat(number) { turn = turn.nextTurn() }
        assertThat(turn.current).isEqualTo(number)
    }
}
