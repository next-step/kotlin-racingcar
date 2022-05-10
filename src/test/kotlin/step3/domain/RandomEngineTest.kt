package step3.domain

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.RepeatedTest

class RandomEngineTest {
    @RepeatedTest(100)
    fun `RandomEngine은 실행시켰을 때 0 또는 1의 값의 거리를 반환한다`() {
        val distance = RandomEngine.getMovableDistance()
        Assertions.assertTrue(
            distance == RandomEngine.MOVE_SUCCESS || distance == RandomEngine.MOVE_FAIL
        )
    }
}