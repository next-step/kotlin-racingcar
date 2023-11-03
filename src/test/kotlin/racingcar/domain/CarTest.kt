package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

private const val MOVE = 4
private const val STOP = 3

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 미만인 경우 정지한다`(value: Int) {
        val car = Car()

        val newCar = car.move(value)

        assertThat(newCar.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상인 경우 이동한다`(value: Int) {
        val car = Car()

        val newCar = car.move(value)

        assertThat(newCar.position).isEqualTo(1)
    }

    @Test
    fun `자동차 여러번 이동`() {
        val car = Car()

        val newCar = car.move(MOVE).move(MOVE).move(MOVE).move(MOVE)

        assertThat(newCar.position).isEqualTo(4)
    }

    @Test
    fun `자동차 여러번 정지`() {
        val car = Car()

        val newCar = car.move(STOP).move(STOP).move(STOP).move(STOP)

        assertThat(newCar.position).isEqualTo(0)
    }

    @Test
    fun `자동차 여러번 이동 및 정지`() {
        val car = Car()

        val newCar = car.move(STOP)
            .move(MOVE)
            .move(MOVE)
            .move(STOP)
            .move(MOVE)
            .move(STOP)

        assertThat(newCar.position).isEqualTo(3)
    }
}
