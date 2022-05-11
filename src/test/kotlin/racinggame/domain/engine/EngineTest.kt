package racinggame.domain.engine

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EngineTest {
    @Test
    fun `엔진을 실행시켜 이동되는 거리를 구할 수 있다`() {
        val engine = Engine { 3 }
        assertThat(engine.getMovableDistance()).isEqualTo(3)
    }

    @Test
    fun `조건에 따라 이동 거리가 달라지는 Engine을 구현할 수도 있다`() {
        val engine = object : Engine {
            var isBroken = false

            override fun getMovableDistance(): Int {
                return if (isBroken) 0 else 10
            }
        }

        assertThat(engine.getMovableDistance()).isEqualTo(10)

        engine.isBroken = true
        assertThat(engine.getMovableDistance()).isEqualTo(0)
    }
}
