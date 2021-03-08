package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.engine.Torque

internal class CarLocationTest {
    @Test
    fun `CarLocation_ZERO는 0이다`() {
        assertThat(CarLocation.ZERO.value).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 234, Int.MAX_VALUE])
    fun `CarLocation은 객체가 달라도 값이 같으면 동일하다`(location: Int) {
        assertThat(CarLocation(location)).isEqualTo(CarLocation(location))
    }

    @ParameterizedTest
    @CsvSource("STOP, 0", "MOVE, 1")
    fun `차의 위치는 Torque를 받으면 그 값만큼 증가한다`(torque: Torque, result: Int) {
        val startLocation = CarLocation.ZERO

        assertThat(startLocation.moveBy(torque)).isEqualTo(CarLocation(result))
    }
}
