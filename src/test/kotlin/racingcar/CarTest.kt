package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `전진하는 조건은 무작위 값이 4 이상 9미만일 경우 이다`(value: Int) {
        val car = Car()
        car.move(value)
        assertThat(car.progress).isEqualTo(true)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `전진하지 않는 조건은 무작위 값이 0이상 3이하일 경우 이다`(value: Int) {
        val car = Car()
        car.move(value)
        assertThat(car.progress).isEqualTo(false)
    }
}
