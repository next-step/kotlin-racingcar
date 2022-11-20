package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CarsTest {
    @Test
    fun `condition 4 이상일 경우 전진한다`() {
        val car = Car("name")

        val cars = Cars(mutableListOf(car))
        repeat(3) {
            cars.move { (4..9).random() }
        }

        assertEquals(cars, Cars(mutableListOf(Car("name", 3))))
    }

    @Test
    fun `condition 4 미만일 경우 전진하지 않는다`() {
        val car = Car("name")

        val cars = Cars(mutableListOf(car))
        repeat(3) {
            cars.move { (0..3).random() }
        }

        assertEquals(cars, Cars(mutableListOf(Car("name", 0))))
    }
}
