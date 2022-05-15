package game.racingcar.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("자동차 이동 전략")
internal class MoveStrategyTest {

    @Test
    fun `무작위 이동 전략`() {
        // given
        val moveStrategy = RandomMoveStrategy()

        // when
        val nextPosition = moveStrategy.move(0)

        // then
        assertThat(nextPosition).isIn(0..9)
    }

    @Test
    fun `테스트용 무조건 움직이기 전략`() {
        // given
        val moveStrategy = MustOneMoveStrategy()

        // when
        val nextPosition = moveStrategy.move(0)

        // then
        assertThat(nextPosition).isEqualTo(1)
    }
}
