package racingcar

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.ui.ResultView

class RacingCarTest {

    @Test
    fun `무작위 값 테스트`() {
        for (i in 1..100) {
            val randInt = RacingCarUtil.createRandomInt()
            assertTrue(randInt in 0..9)
        }
    }

    @Test
    fun `전진 조건 테스트`() {
        assertTrue(RacingCarUtil.checkMoveValue(5))
    }

    @Test
    fun `전진 조건이 아닌 경우 테스트`() {
        assertFalse(RacingCarUtil.checkMoveValue(3))
    }

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
