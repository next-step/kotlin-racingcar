package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7])
    fun `0에서 9사이의 랜덤 값이 4 이상일 경우 전진한다`(input: Int) {
        val car = Car()
        car.move(input)
        assertThat(car.position).isEqualTo(2)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `0에서 9사이의 랜덤 값이 4 미만일 경우 멈춘다`(input: Int) {
        val car = Car()
        car.move(input)
        assertThat(car.position).isEqualTo(1)
    }
}
