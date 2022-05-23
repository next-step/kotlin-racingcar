package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RandomValueMovingStrategyTest {

    @Test
    fun `랜덤 숫자가 전진하는 조건은 4 이상이다`() {
        val randomValueMovingStrategy = AlwaysForwardStrategy()
        assertThat(randomValueMovingStrategy.forwardMovable()).isTrue
    }

    @Test
    fun `랜덤 숫자가 전진하지 않는 조건은 4 미만이다`() {
        val randomValueMovingStrategy = AlwaysStopStrategy()
        assertThat(randomValueMovingStrategy.forwardMovable()).isFalse
    }
}
