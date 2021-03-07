package racingcar.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.racing.car.engine.Engine
import racingcar.racing.car.engine.Torque

internal class CarTest {
    private val dummyEngine = object : Engine {
        override fun run() = Torque.STOP
    }

    @ParameterizedTest
    @ValueSource(strings = ["BMW", "포드", "애스턴마틴"])
    fun `차를 생성하면 이름은 생성할 때 넣은 이름이고, 초기 위치는 0이다`(name: String) {
        val car = Car(CarName(name), dummyEngine)
        assertAll(
            { assertThat(car.name).isEqualTo(CarName(name)) },
            { assertThat(car.location).isEqualTo(CarLocation.ZERO) }
        )
    }

    @ParameterizedTest
    @EnumSource
    fun `차는 race할 때마다, 엔진이 주는 값만큼 위치가 바뀐다`(torque: Torque) {
        val car = Car(
            CarName("슈마허"),
            engine = object : Engine {
                override fun run() = torque
            }
        )
        car.race()
        assertThat(car.location).isEqualTo(CarLocation(torque.value))
    }
}
