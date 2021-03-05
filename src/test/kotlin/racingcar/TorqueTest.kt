package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class TorqueTest {
    @ParameterizedTest
    @ValueSource(ints = [Int.MIN_VALUE, -384, 0, 234, Int.MAX_VALUE])
    fun `Torque는 객체가 달라도 값이 같으면 동일하다`(torque: Int) {
        Assertions.assertThat(Torque(torque)).isEqualTo(Torque(torque))
    }
}
