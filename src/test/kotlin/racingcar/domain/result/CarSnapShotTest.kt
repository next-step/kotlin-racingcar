package racingcar.domain.result

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.vo.Name
import racingcar.domain.car.vo.Position

class CarSnapShotTest {
    @Test
    fun `스냅샷 생성`() {
        val car = Car(Name("제이"), Position(10))
        val carSnapShot = CarSnapShot(car)

        assertAll({
            assertThat(carSnapShot.name).isEqualTo("제이")
            assertThat(carSnapShot.position).isEqualTo(10)
        })
    }

    @Test
    fun `동일한 위치인지 확인`() {
        val car = Car(Name("제이"), Position(10))
        val carSnapShot = CarSnapShot(car)

        assertAll({
            assertThat(carSnapShot.isSamePositionWith(10)).isTrue
            assertThat(carSnapShot.isSamePositionWith(9)).isFalse
        })
    }
}
