package step3.turn

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TurnImplTest {
    @Test
    fun `current 초기값이 0`() {
        assertThat(TurnImpl { }.current).isEqualTo(0)
    }

    @Test
    fun `nextTurn()이 doEachTurn을 매번 호출`() {
        var hasBeenCalled = false
        val turn = TurnImpl { hasBeenCalled = true }
        turn.nextTurn()
        assertThat(hasBeenCalled).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 10])
    fun `nextTurn()이 호출될 때 마다 current 증가`(number: Int) {
        val turn = TurnImpl { }
        repeat(number) { turn.nextTurn() }
        assertThat(turn.current).isEqualTo(number)
    }
}
