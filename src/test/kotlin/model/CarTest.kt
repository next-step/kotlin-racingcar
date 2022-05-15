package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `default distance`() {
        assertThat(Car("test").getDistance() == 1)
    }

    @Test
    fun go() {
        val car = Car("test")
        car.go()
        assertThat(car.getDistance() == 2)
    }
}
