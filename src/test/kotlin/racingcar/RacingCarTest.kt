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
        assertTrue(Car().move(6) == 1)
    }

    @Test
    fun `전진 실패 테스트`() {
        assertTrue(Car().move(3) == 0)
    }

    @Test
    fun `자동차 경주 자동차 생성 테스트`() {
        val carCount = 3

        assertTrue(RacingCar(carCount, 0).start().size == carCount)
    }

    @Test
    fun `자동차 경주 시도 횟에 따른 이동 히스토리 생성 테스트`() {
        val tryCount = 5

        assertTrue(RacingCar(1, tryCount).start()[0].moveHistory.size == tryCount)
    }
}
