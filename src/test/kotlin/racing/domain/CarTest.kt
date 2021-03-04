package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun moveCar() {
        val car = Car("name")
        assertThat(car.position).isEqualTo(CarPosition.INIT_POSITION)

        car.moveCar()
        assertThat(car.position.position).isEqualTo(1)
    }

    @Test
    fun getName() {
        val car = Car("name")
        assertThat(car.name.name).isEqualTo("name")
    }

    @Test
    fun getPosition() {
        val car = Car("name").apply { moveCar() }
        assertThat(car.position.position).isEqualTo(1)
    }
}
