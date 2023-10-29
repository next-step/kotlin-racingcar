package racing.car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarFactoryTest {

    @Test
    fun manufacture() {
        val actual = CarFactory.manufactureRacingCar(2)
        assertThat(actual.size).isEqualTo(2)
        assertThat(actual.component1()).isExactlyInstanceOf(RacingCar::class.java)
    }
}
