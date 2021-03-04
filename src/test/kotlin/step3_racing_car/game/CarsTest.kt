package step3_racing_car.game

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
        Cars.register(numOfCar)
        // then
        assertThat(Cars.list.size).isEqualTo(numOfCar)
    }

    @Test
    fun moveFailTest() {
        // given
        val position = 0
        val car = Car(position)
        // when
        val condition = 1
        car.move(condition)
        // then
        assertThat(car.position).isEqualTo(position)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 9])
    fun moveSuccessTest(input: Int?) {
        // given
        val position = 0
        val car = Car(position)
        // when
        val condition = input
        condition?.let { car.move(it) }
        // then
        assertThat(car.position).isEqualTo(position + 1)
    }
}
