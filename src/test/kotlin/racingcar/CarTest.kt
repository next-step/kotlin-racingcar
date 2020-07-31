package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    @DisplayName("자동차 전진 테스트(전진)")
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun forward(number: Int) {
        val car = Car("Tester")
        assertThat(car.accelerate(number)).isEqualTo(1)
    }

    @DisplayName("자동차 전진 테스트(제자리)")
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun notForward(number: Int) {
        val car = Car("Tester")
        assertThat(car.accelerate(number)).isEqualTo(0)
    }

    @DisplayName("자동차 전진 테스트(예외)")
    @Test
    fun accelateException() {
        val car = Car("Tester")
        assertThrows<IllegalArgumentException> {
            car.accelerate(10)
        }

        assertThrows<IllegalArgumentException> {
            car.accelerate(-1)
        }
    }
}
