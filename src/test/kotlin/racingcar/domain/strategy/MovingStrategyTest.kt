package racingcar.domain.strategy

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("이동 전략(MovingStrategy)")
class MovingStrategyTest {
    @Test
    fun `이동 기준 이상의 숫자가 나오면 이동할 수 있다`() {
        assertAll(
            { assertThat(TestMovingStrategy(MOVING_CRITERIA + 1).isMovable()).isTrue },
            { assertThat(TestMovingStrategy(MOVING_CRITERIA).isMovable()).isTrue },
            { assertThat(TestMovingStrategy(MOVING_CRITERIA - 1).isMovable()).isFalse },
            { assertThat(TestMovingStrategy(MOVING_CRITERIA - 2).isMovable()).isFalse },
        )
    }
}
