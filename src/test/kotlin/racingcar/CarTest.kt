package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    private val dummyEngine = object : Engine {
        override fun run() = Torque(0)
    }

    @Test
    fun `차의 초기 위치는 0이다`() {
        assertThat(Car(dummyEngine).location).isEqualTo(CarLocation(0L))
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1, 32, Int.MAX_VALUE])
    fun `차는 race할 때마다, 엔진이 주는 값만큼 위치가 바뀐다`(torque: Int) {
        val car = Car(
            engine = object : Engine {
                override fun run() = Torque(torque)
            }
        )
        val firstLocation = car.race()
        val secondLocation = car.race()

        assertAll(
            { assertThat(firstLocation).isEqualTo(CarLocation(torque.toLong())) },
            { assertThat(secondLocation).isEqualTo(CarLocation(torque.toLong() + torque.toLong())) }
        )
    }
}
