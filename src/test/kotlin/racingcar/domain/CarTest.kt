package racingcar.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 전진할 수 있다`() {
        val car = Car(1)
        car.drive()
        Assertions.assertThat(car.distance).isEqualTo(2)
    }
}