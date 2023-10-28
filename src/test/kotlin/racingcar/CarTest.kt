package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @Test
    fun `차의 초기 위치는 0이다`() {
        val car = Car()

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상인 경우 차는 이동할 수 있다`(number: Int) {
        val car = Car()

        car.tryMove(number)

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `숫자가 4 미만인 경우 차는 이동하지 못한다`(number: Int) {
        val car = Car()

        car.tryMove(number)

        assertThat(car.position).isEqualTo(0)
    }
}
