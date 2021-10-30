package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Car
import kotlin.IllegalArgumentException

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `accelerate 실행 시 4 이상의 fuel 을 받으면 position 이 1 증가 한다`(input: Int) {
        val car = Car("car1")

        car.accelerate(input)

        assertThat(car.position).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `accelerate 실행 시 4 미만의 fuel 을 받으면 position 이 증가하지 않는다`(input: Int) {
        val car = Car("car1")

        car.accelerate(input)

        assertThat(car.position).isEqualTo(0)
    }

    @Test
    fun `자동차 이름이 5자를 초과하는 경우, IllegalArgumentException 를 일으킨다`() {
        assertThrows<IllegalArgumentException> {
            Car("123456")
        }
    }
}
