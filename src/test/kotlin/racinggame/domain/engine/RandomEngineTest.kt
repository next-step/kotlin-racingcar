package racinggame.domain.engine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest

class RandomEngineTest {
    @RepeatedTest(100)
    fun `RandomEngine은 실행시켰을 때 0 또는 1의 값의 거리를 반환한다`() {
        val distance = RandomEngine.getMovableDistance()

        assertThat(distance).isIn(RandomEngine.MOVE_SUCCESS, RandomEngine.MOVE_FAIL)
    }
}