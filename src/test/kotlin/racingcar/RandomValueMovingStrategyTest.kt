package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
internal class RandomValueMovingStrategyTest {


    @Test
    fun `랜덤 숫자가 전진하는 조건은 4 이상이다`() {
        val randomValueMovingStrategy = RandomValueMovingStrategy(4)
        assertThat(randomValueMovingStrategy.movable()).isTrue
    }

    @Test
    fun `랜덤 숫자가 전진하지 않는 조건은 4 미만이다`() {
        val randomValueMovingStrategy = RandomValueMovingStrategy(3)
        assertThat(randomValueMovingStrategy.movable()).isFalse
    }

    @Test
    fun `랜덤 숫자를 생성한다`() {
        val randomValueMovingStrategy = RandomValueMovingStrategy(4)
        assertThat(randomValueMovingStrategy.number).isEqualTo(4)
    }
}