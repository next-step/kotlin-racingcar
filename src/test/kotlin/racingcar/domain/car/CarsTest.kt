package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertDoesNotThrow
import racingcar.domain.Name
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
        val newCars = cars.play(numberPicker)
        val newCar1 = newCars.cars[0]
        val newCar2 = newCars.cars[1]
        val newCar3 = newCars.cars[2]

        // then
        assertAll(
            { assertThat(newCar1.position).isEqualTo(expected) },
            { assertThat(newCar2.position).isEqualTo(expected) },
            { assertThat(newCar3.position).isEqualTo(expected) },
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

    @Test
    fun `car1 is winner when car1 has position 1 and car2 has position 0`() {
        // given
        val car1 = Car(Name("car1"))
        val car2 = Car(Name("car2"))
        val cars = Cars(listOf(car1, car2))
        val numberPicker = FakeNUmberPicker(mutableListOf(4, 3))

        // when
        val newCars = cars.play(numberPicker)
        val expected = listOf(newCars.cars[0])
        val actual = newCars.getWinners()

        // then
        assertThat(actual.cars).hasSameElementsAs(expected)
    }

    @Test
    fun `car1 and car2 are winners when car1 has position 1 and car2 has position 1`() {
        // given
        val car1 = Car(Name("car1"))
        val car2 = Car(Name("car2"))
        val cars = Cars(listOf(car1, car2))
        val numberPicker = FakeNUmberPicker(mutableListOf(4, 4))

        // when
        val newCars = cars.play(numberPicker)
        val expected = listOf(newCars.cars[0], newCars.cars[1])
        val actual = newCars.getWinners()

        // then
        assertThat(actual.cars).hasSameElementsAs(expected)
    }

    @Test
    fun `Can create Cars by passing only names to constructor`() {
        // given
        val name1 = Name("wise")
        val name2 = Name("muji")
        val names = listOf(name1, name2)

        // when && then
        assertDoesNotThrow { Cars.from(names) }
    }

    private class FakeNUmberPicker(private val numbers: MutableList<Int>) : NumberPicker {
        override fun getNumber(): Int {
            return numbers.removeFirst()
        }
    }
}
