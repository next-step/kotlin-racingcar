package step3.turn

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TurnManagerImplTest {
    @Test
    fun `isFinishOrProceed() 끝나지 않았으면 nextTurn호출하고 false 반환`() {
        var hasBeenCalled = false
        val turn = TurnImpl { hasBeenCalled = true }
        val manager = TurnManagerImpl(10, turn)
        assertThat(manager.isFinishOrProceed()).isFalse()
        assertThat(hasBeenCalled).isTrue()
    }

    @Test
    fun `isFinishOrProceed() 끝났으면 nextTurn호출하지 않고 true 반환`() {
        var hasBeenCalled = false
        val turn = TurnImpl { hasBeenCalled = true }
        val manager = TurnManagerImpl(0, turn)
        assertThat(manager.isFinishOrProceed()).isTrue()
        assertThat(hasBeenCalled).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `isFinish() turn이 실행된 횟수가 totalStep보다 작으면 false`(number: Int) {
        val manager = TurnManagerImpl(
            10,
            mockk<TurnImpl>().apply {
                every { current } returns number
            }
        )
        assertThat(manager.isFinish()).isFalse()
    }

    @ParameterizedTest
    @ValueSource(ints = [10, 11, 12, 13, 14, 15, 16, 17, 18, 19])
    fun `isFinish() turn이 실행된 횟수가 totalStep보다 크거나 같으면 True`(number: Int) {
        val manager = TurnManagerImpl(
            10,
            mockk<TurnImpl>().apply {
                every { current } returns number
            }
        )
        assertThat(manager.isFinish()).isTrue()
    }
}
