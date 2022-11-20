package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6])
    fun `자동차는 무작위 값이 4 이상일 경우 전진한다`(input: Int) {
        // given
        val car = Car()

        // when
        car.move(input)

        // then
        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `자동차는 무작위 값이 4 미만일 경우 정지한다`(input: Int) {
        // given
        val car = Car()

        // when
        car.move(input)

        // then
        assertThat(car.position).isEqualTo(0)
    }
}
