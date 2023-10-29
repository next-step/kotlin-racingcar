package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarInitializerTest {
    @Test
    fun `Car 생성`() {
        val cars = CarInitializer.createCars(5)
        assertThat(cars.size).isEqualTo(5)
    }
}
