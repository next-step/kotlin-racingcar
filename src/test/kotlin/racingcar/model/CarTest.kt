package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.mock.AlwaysBackwardRacingCarForwardCondition
import racingcar.mock.AlwaysForwardRacingCarForwardCondition

class CarTest {

    @Test
    fun `자동차 전진 기능 테스트`() {
        // given
        val condition = AlwaysForwardRacingCarForwardCondition()
        var car = Car(carName = CarName(""))

        // when
        val expected = 3
        repeat(3) { car = car.tryMove(condition) }
        val actual = car.position

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `자동차 후진 기능 테스트`() {
        // given
        val condition = AlwaysBackwardRacingCarForwardCondition()
        var car = Car(
            carName = CarName(""),
            position = 5
        )

        // when
        val expected = 0
        repeat(5) { car = car.tryMove(condition) }
        val actual = car.position

        // then
        assertEquals(expected, actual)
    }

    @Test
    fun `자동차는 음수 위치로 후진할 수 없다`() {
        // given
        val condition = AlwaysBackwardRacingCarForwardCondition()
        var car = Car(carName = CarName(""), position = 5)

        // when
        val expected = 0
        repeat(100) { car = car.tryMove(condition) }
        val actual = car.position

        // then
        assertEquals(expected, actual)
    }
}
