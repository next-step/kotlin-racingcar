package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun moveCar() {
        val car = Car()
        assertThat(car.position).isEqualTo(0)

        car.moveCar()
        assertThat(car.position).isEqualTo(1)
    }
}
