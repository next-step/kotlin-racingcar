package racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class RandomMoveStrategyTest {
    lateinit var moveStrategy: MoveStrategy

    @Test
    fun `랜덤 숫자 4미만이 나올 경우`() {
        moveStrategy = RandomMoveStrategy(0..3)
        Assertions.assertThat(moveStrategy.move()).isFalse
    }

    @Test
    fun `랜덤 숫자 4이상이 나올 경우`() {
        moveStrategy = RandomMoveStrategy(4..9)
        Assertions.assertThat(moveStrategy.move()).isTrue
    }
}
