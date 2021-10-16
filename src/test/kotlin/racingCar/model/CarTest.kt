package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `차를 전진 시켜 보자`() {
        assertThat(Car().forward().mileage).isEqualTo(1)
    }
}
