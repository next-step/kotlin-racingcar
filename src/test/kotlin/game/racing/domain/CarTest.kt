package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상의 값이 입력되면 이동한다`(value: Int) {
        val car = Car()

        assertThat(car.isMovePossible(value)).isTrue()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 이하의 값이 입력되면 이동하지 않는다`(value: Int) {
        val car = Car()

        assertThat(car.isMovePossible(value)).isFalse()
    }

    @Test
    fun `0부터 9사이의 랜덤값을 반환한다`() {
        val car = Car()

        repeat(10) {
            assertThat(car.getRandomValue()).isBetween(Car.MIN_RANDOM_VALUE, Car.MAX_RANDOM_VALUE)
        }
    }
}
