package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    @DisplayName("position 1 인 RacingCar 객체를 선언하고 / moveForward() 호출 시 / 2가 반환되는지 확인")
    fun moveForward() {
        // given
        val racingCar = RacingCar("test", 1)
        val fourOrMoreGameRule = FourOrMoreGameRule()

        // when
        racingCar.moveForward(fourOrMoreGameRule)

        // then
        assertEquals(2, racingCar.currentPosition)
    }
}
