package racingcar.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import racingcar.racing.car.engine.Engine
import racingcar.racing.car.engine.Torque

internal class CarTest {
    private val dummyEngine = object : Engine {
        override fun run() = Torque.STOP
    }

    @Test
    fun `차의 초기 위치는 0이다`() {
        assertThat(Car(dummyEngine).location).isEqualTo(CarLocation.ZERO)
    }

    @ParameterizedTest
    @EnumSource
    fun `차는 race할 때마다, 엔진이 주는 값만큼 위치가 바뀐다`(torque: Torque) {
        val car = Car(
            engine = object : Engine {
                override fun run() = torque
            }
        )
        assertThat(car.race()).isEqualTo(CarLocation(torque.value))
    }
}
