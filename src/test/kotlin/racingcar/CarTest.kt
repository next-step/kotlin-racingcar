package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `자동차의 초기 위치는 0 이다`(initPosition: Int) {
        val car = Car()
        Assertions.assertThat(car.position).isEqualTo(initPosition)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자 값이 4 이상인 경우 자동차는 움직인다`(condition: Int) {
        val car = Car()
        car.move(condition)
        Assertions.assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun `랜덤 숫자 값이 4 미만인 경우 자동차는 움직이지 않는다`(condition: Int) {
        val car = Car()
        car.move(condition)
        Assertions.assertThat(car.position).isEqualTo(0)
    }
}
