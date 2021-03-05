package racingcar.game

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarsTest {
    @Test
    fun registerTest() {
        // given
        val numOfCar = 5
        // when
        val participant = Participant(numOfCar)

        // then
        assertThat(participant.cars.size).isEqualTo(numOfCar)
    }

    @Test
    fun moveFailTest() {
        // given
        val car = Car()
        // when
        val condition = 1
        car.move(condition)
        // then
        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 9])
    fun moveSuccessTest(input: Int) {
        // given
        val car = Car()
        // when
        car.move(input)
        // then
        assertThat(car.position).isEqualTo(1)
    }
}
