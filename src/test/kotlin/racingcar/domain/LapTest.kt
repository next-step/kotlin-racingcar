package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LapTest {

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -2])
    fun `각 라운드는 1보다 작을 수 없다`(value: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Lap(value) }
    }
}
