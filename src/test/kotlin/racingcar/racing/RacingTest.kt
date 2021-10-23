package racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.car.Car
import racingcar.racing.Racing.initCars
import racingcar.racing.Racing.moveCarForward

class RacingTest {
    @Test
    fun `자동차 초기화`() {
        assertEquals(3, initCars(3).size)
    }

    @Test
    fun `자동차 이동`() {
        var cars = listOf(Car())
        cars = moveCarForward(cars)
        assertThat(cars[0].status).isGreaterThanOrEqualTo(1)
    }
}
