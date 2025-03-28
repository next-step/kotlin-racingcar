package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.Car

class CarTest {
    @Test
    fun `Position should be 0 when car is created`() {
        // given && when
        val car = Car(Name(""))

        // then
        assertThat(car.position).isEqualTo(0)
    }

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `Car can move forward when the number is greater than 4`(number: Int) {
        // given
        val car = Car(Name(""))

        // when
        car.move(Moving(number))
        val expected = 1

        // then
        assertThat(car.position).isEqualTo(expected)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `Car cannot move forward when the number is less than 4`(number: Int) {
        // given
        val car = Car(Name(""))

        // when
        car.move(Moving(number))
        val expected = 0

        // then
        assertThat(car.position).isEqualTo(expected)
    }
}
