package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.common.RandomNumber
import racingcar.domain.Car
import racingcar.domain.Car.Companion.move
import racingcar.domain.CarBehavior

class RaceTest {

    @Test
    @DisplayName("자동차의 수가 0일 경우 IllegalArgumentException 오류")
    fun test1() {
        val numberOfCars = 0
        assertThrows<IllegalArgumentException> { Car.registerCars(numberOfCars) }
    }

    @Test
    @DisplayName("랜덤 값의 범위가 0부터 9까지 일 경우 그 사이 값이 나옴")
    fun test2() {
        val num = RandomNumber(0..9).generate()
        assertThat(num)
            .isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9)
    }
}
