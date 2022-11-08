package racingcar

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car

class RaceTest {

    @Test
    @DisplayName("자동차의 수가 0일 경우 IllegalArgumentException 오류")
    fun test1() {
        val numberOfCars = 0
        assertThrows<IllegalArgumentException> { Car.registerCars(numberOfCars) }
    }
}
