package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import racingcar.move.ForwardStrategy
import racingcar.ui.ResultView

class RacingCarTest {

    @Test
    fun `전진 문자 테스트`() {
        assertTrue(ResultView().getMoveString(3) == "---")
    }

    @Test
    fun `전진 성공 테스트`() {
        assertTrue(Car().move(6) == 1)
    }

    @Test
    fun `전진 실패 테스트`() {
        assertTrue(Car().move(3) == 0)
    }

    @Test
    fun `자동차 경주 자동차 생성 테스트`() {
        val carCount = 3

        val racingHistory = RacingCar(3, 1).start(ForwardStrategy.CarForward)

        assertTrue(racingHistory.keys.toList().size == carCount)
    }

    @Test
    fun `자동차 경주 시도 횟에 따른 이동 히스토리 생성 테스트`() {
        val tryCount = 5

        val racingHistory = RacingCar(3, tryCount).start(ForwardStrategy.CarForward)

        assertTrue(racingHistory.values.toList()[0].size == tryCount)
    }
}
