package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.numberpicker.NumberPicker

class CarsTest {
    @Test
    fun `all cars move forward when the numbers are over than 4 or equal to 4`() {
        // given
        val car1 = Car(Name("car1"))
        val car2 = Car(Name("car2"))
        val car3 = Car(Name("car3"))
        val cars = Cars(listOf(car1, car2, car3))
        val numberPicker = FakeNUmberPicker(mutableListOf(4, 4, 4))
        val expected = 1

        // when
        cars.play(numberPicker)

        // then
        assertAll(
            { assertThat(car1.position).isEqualTo(expected) },
            { assertThat(car2.position).isEqualTo(expected) },
            { assertThat(car3.position).isEqualTo(expected) },
        )
    }

    @Test
    fun `cars doesn't move forward when the numbers are less than 4`() {
        // given
        val car1 = Car(Name("car1"))
        val car2 = Car(Name("car2"))
        val car3 = Car(Name("car3"))
        val cars = Cars(listOf(car1, car2, car3))
        val numberPicker = FakeNUmberPicker(mutableListOf(3, 3, 3))
        val expected = 0

        // when
        cars.play(numberPicker)

        // then
        assertAll(
            { assertThat(car1.position).isEqualTo(expected) },
            { assertThat(car2.position).isEqualTo(expected) },
            { assertThat(car3.position).isEqualTo(expected) },
        )
    }

    private class FakeNUmberPicker(private val numbers: MutableList<Int>) : NumberPicker {
        override fun getNumber(): Moving {
            return Moving(numbers.removeFirst())
        }
    }
}