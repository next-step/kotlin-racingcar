package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `자동차는 4이상의 숫자일 때 이동한다`(number: Int) {
        val car = Car.init("pobi,crong,honux")

        car.move(number)

        assertThat(car.position).isEqualTo(Position(1))
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `자동차는 4미만의 숫자일 때 이동하지 않는다`(number: Int) {
        val car = Car.init("pobi,crong,honux")

        car.move(number)

        assertThat(car.position).isEqualTo(Position(0))
    }

    @ParameterizedTest
    @ValueSource(ints = [-2, -1, 10, 11])
    fun `자동차는 0미만 혹은 9초과의 숫자일 때 에러가 발생한다`(number: Int) {
        val car = Car.init("pobi,crong,honux")

        assertThatThrownBy {
            car.move(number)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
