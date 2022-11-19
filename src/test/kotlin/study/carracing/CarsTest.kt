package study.carracing

import carracing.domain.Car
import carracing.domain.Cars
import carracing.domain.Name
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarsTest {

    @Test
    fun makeCarsTest() {
        val car1 = Car(Name("lee"))
        val car2 = Car(Name("kim"))
        val car3 = Car(Name("park"))
        val cars = Cars(listOf(car1, car2, car3))
        assertThat(cars.size).isEqualTo(3)
    }

    @Test
    fun `한대 이하의 자동차 생성시 오류 발생`() {
        assertThrows<IllegalArgumentException> {
            val car1 = Car(Name("kim"))
            Cars(listOf(car1))
        }
    }
}
