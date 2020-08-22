package racingCar

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.domain.Car

class RacingCarTest {

    @Test
    fun `자동차 이름은 5글자를 초과할 수 없다`() {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            Car("chanheeee")
        }
    }

    @Test
    fun `자동차는 각 이동마다 전진 혹은 멈출 수 있다`() {
        val car = Car("찬희")
        car.changeStateRacingCar(true)
        car.changeStateRacingCar(false)
        car.changeStateRacingCar(true)
        assertThat(car.distance).isEqualTo(2)
    }
}
