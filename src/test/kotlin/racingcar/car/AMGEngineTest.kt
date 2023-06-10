package racingcar.car

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class AMGEngineTest {
    @Test
    fun `amg 엔진은 rpm 이 0~9 사이 수가 나온다`() {
        val amgEngine = AMGEngine()
        val rpm = amgEngine.rpm
        Assertions.assertThat(rpm in (0..9)).isTrue()
    }
}
