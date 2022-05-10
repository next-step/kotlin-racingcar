package step3.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

class EngineTest {
    @Test
    fun `엔진을 실행시켜 이동되는 거리를 구할 수 있다`() {
        val engine1 = Engine { 3 }
        assertThat(engine1.getMovableDistance()).isEqualTo(3)

        val engine2 = object : Engine {
            var isBroken = false

            override fun getMovableDistance(): Int {
                return if (isBroken) 0 else 10
            }
        }
        assertThat(engine2.getMovableDistance()).isEqualTo(10)

        engine2.isBroken = true
        assertThat(engine2.getMovableDistance()).isEqualTo(0)
    }

    @RepeatedTest(100)
    fun `RandomEngine은 실행시켰을 때 0 또는 1의 값의 거리를 반환한다`() {
        val distance = RandomEngine.getMovableDistance()
        assertTrue(
            distance == RandomEngine.MOVE_SUCCESS || distance == RandomEngine.MOVE_FAIL
        )
    }
}
