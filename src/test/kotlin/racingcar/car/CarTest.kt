package racingcar.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `자동차 생성 시도`() {
        assertThat(Car().status).isEqualTo(1)
    }

    @Test
    fun `자동차 이동`() {
        var car = Car()
        car.move()
        assertThat(car.status).isGreaterThanOrEqualTo(1)
    }
}
