package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CarTest{
    @Test
    fun `default distance`() {
        assertThat(Car().getDistance() == 1)
    }

    @Test
    fun `go stop`() {
        val car = Car()
        car.goStop()
        assertThat(car.getDistance() == 1 || car.getDistance() == 2)
    }
}