package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.engine.Torque

internal class CarLocationTest {
    @Test
    fun `ZERO는 정수 0값을 가진다`() {
        assertThat(CarLocation.ZERO.value).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 234, Int.MAX_VALUE])
    fun `차의 위치(CarLocation)는 객체가 달라도 값이 같으면 동일하다`(location: Int) {
        assertThat(CarLocation(location)).isEqualTo(CarLocation(location))
    }

    @ParameterizedTest
    @CsvSource("STOP, 0", "MOVE, 1")
    fun `차의 위치는 STOP을 받으면 변하지 않고, MOVE를 받으면 위치가 1 증가한다`(torque: Torque, result: Int) {
        val startLocation = CarLocation.ZERO

        assertThat(startLocation.moveBy(torque)).isEqualTo(CarLocation(result))
    }
}
