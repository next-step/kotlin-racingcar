package game.racing.domain

import game.racing.domain.Car.Companion.MIN_POSITION
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상의 값이 입력되면 이동한다`(value: Int) {
        val car = Car()
        car.move(value)

        assertThat(car.position).isEqualTo(MIN_POSITION + 1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 이하의 값이 입력되면 이동하지 않는다`(value: Int) {
        val car = Car()
        car.move(value)

        assertThat(car.position).isEqualTo(MIN_POSITION)
    }
}
