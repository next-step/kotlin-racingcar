package study.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.domain.Car

internal class CarTest {

    @Test
    fun `Car 초기 값 테스트`() {
        val car = Car()

        assertThat(car.position).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `condition이 4 이상일 때 움직인다`(condition: Int) {
        val car = Car()

        car.move(condition)

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `condition이 4 이하일 때 움직이지 않는다`(condition: Int) {
        val car = Car()

        car.move(condition)

        assertThat(car.position).isEqualTo(0)
    }
}
