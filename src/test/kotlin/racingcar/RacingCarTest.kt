package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.ui.ResultView

class RacingCarTest {

    @Test
    fun `전진 문자 테스트`() {
        assertTrue(ResultView().getMoveString(3) == "---")
    }

    @Test
    fun `전진 성공 테스트`() {
        val car = Car()
        car.move(6)
        assertTrue(car.moveCount == 1)
    }

    @Test
    fun `전진 실패 테스트`() {
        val car = Car()
        car.move(3)
        assertTrue(car.moveCount == 0)
    }
}
