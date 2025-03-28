package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Moving
import racingcar.domain.Name

class CarTest {
    @Test
    fun `Position should be 0 when car is created`() {
        // given && when
        val car = Car(Name(""))

        // then
        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `move should return same instance when move is less than 4`() {
        // given
        val car = Car(Name(""))

        // when
        val newCar = car.move(Moving(3))

        // then
        assertAll(
            { assertThat(car.name).isEqualTo(newCar.name) },
            { assertThat(car.position).isEqualTo(newCar.position) },
            { assertThat(car).isSameAs(newCar) }
        )
    }

    @Test
    fun `move should return different instance when move is over than 4 or equal to 4`() {
        // given
        val car = Car(Name(""))

        // when
        val newCar = car.move(Moving(5))

        // then
        assertThat(car).isNotSameAs(newCar)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `Car can move forward when the number is greater than 4`(number: Int) {
        // given
        val car = Car(Name(""))

        // when
        val newCar = car.move(Moving(number))
        val expected = 1

        // then
        assertThat(newCar.position).isEqualTo(expected)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `Car cannot move forward when the number is less than 4`(number: Int) {
        // given
        val car = Car(Name(""))

        // when
        val newCar = car.move(Moving(number))
        val expected = 0

        // then
        assertThat(newCar.position).isEqualTo(expected)
    }
}
