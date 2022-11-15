package study.carracing

import carracing.domain.Car
import carracing.domain.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun makeCarsTest() {
        val car1 = Car()
        val car2 = Car()
        val car3 = Car()
        val cars = Cars(listOf(car1, car2, car3))
        assertThat(cars.size).isEqualTo(3)
    }

    @Test
    fun `한대 이하의 자동차 생성시 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            val car1 = Car()
            Cars(listOf(car1))
        }
    }
}
