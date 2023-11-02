package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import study.racingcar.application.CarName

class RacingCarTest {

    @Test
    @DisplayName("position 0 인 RacingCar 객체를 선언하고 / moveForward() 호출 시 / 1가 반환되는지 확인")
    fun moveForward() {
        // given
        val racingCar = RacingCar(CarName("test"))
        val fourOrMoreGameRule = FourOrMoreGameRule()

        // when
        racingCar.moveForward(fourOrMoreGameRule)

        // then
        assertEquals(1, racingCar.currentPosition)
    }
}
