package racingCar.entity

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CarImplTest {

    @Test
    fun `자동차가 이동하면 distance가 1 증가한다`() {
        // given
        val car = CarImpl("A")
        val expectedDistance = car.distance
        val moves = 6

        // when
        val testCar = car.move(moves)

        // then
        Assertions.assertThat(testCar.distance).isEqualTo(expectedDistance + 1)
    }

    @Test
    fun `move()에 4 이상의 숫자가 들어가면 자동차가 1 이동한다`() {
        // given
        val car = CarImpl("A")
        val expectedDistance = car.distance
        val randomNumber = 4

        // when
        val testCar = car.move(randomNumber)

        // then
        Assertions.assertThat(testCar.distance).isEqualTo(expectedDistance + 1)
    }

    @Test
    fun `move()에 4 미만의 숫자가 들어가면 자동차가 이동하지 않는다`() {
        // given
        val car = CarImpl("A")
        val expectedDistance = car.distance
        val randomNumber = 2

        // when
        val testCar = car.move(randomNumber)

        // then
        Assertions.assertThat(testCar.distance).isEqualTo(expectedDistance)
    }
}
