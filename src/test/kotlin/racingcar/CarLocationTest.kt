package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarLocationTest {
    @ParameterizedTest
    @ValueSource(longs = [0, 234, Long.MAX_VALUE])
    fun `CarLocation은 객체가 달라도 값이 같으면 동일하다`(location: Long) {
        assertThat(CarLocation(location)).isEqualTo(CarLocation(location))
    }

    @ParameterizedTest
    @ValueSource(ints = [Int.MIN_VALUE, -3, 0, 42345, Int.MAX_VALUE])
    fun `차의 위치는 Torque를 받으면 그 값만큼 증가한다`(torque: Int) {
        val startLocation = CarLocation(0L)

        val firstLocation = startLocation + Torque(torque)
        val secondLocation = firstLocation + Torque(3)
        val thirdLocation = secondLocation + Torque(-5)

        assertAll(
            { assertThat(firstLocation).isEqualTo(CarLocation(torque.toLong())) },
            { assertThat(secondLocation).isEqualTo(CarLocation(torque.toLong() + 3L)) },
            { assertThat(thirdLocation).isEqualTo(CarLocation(torque.toLong() - 2L)) }
        )
    }
}
