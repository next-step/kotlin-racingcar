package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4 미만인 경우 정지한다`(value: Int) {
        val car = Car()

        car.move(value)

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4 이상인 경우 이동한다`(value: Int) {
        val car = Car()

        car.move(value)

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `자동차 여러번 이동`() {
        val car = Car()

        car.move(4)
        car.move(5)
        car.move(6)
        car.move(7)

        assertThat(car.position).isEqualTo(4)
    }

    @Test
    fun `자동차 여러번 정지`() {
        val car = Car()

        car.move(0)
        car.move(1)
        car.move(2)
        car.move(3)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차 여러번 이동 및 정지`() {
        val car = Car()

        car.move(0)
        car.move(4)
        car.move(5)
        car.move(1)
        car.move(6)
        car.move(2)

        assertThat(car.position).isEqualTo(3)
    }
}
