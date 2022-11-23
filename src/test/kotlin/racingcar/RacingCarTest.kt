package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `전진 성공 테스트`() {
        val forward = ForwardStrategy.CarPassForward

        assertTrue(Car("자동차").move(forward.forward()) == 1)
    }

    @Test
    fun `전진 실패 테스트`() {
        val forward = ForwardStrategy.CarNotForward

        assertTrue(Car("자동차").move(forward.forward()) == 0)
    }

    @Test
    fun `자동차 경주 자동차 생성 테스트`() {
        val carNames = "자동차1,자동차2,자동차3"

        val racingHistory = RacingCar(carNames, 1).start(ForwardStrategy.CarForward)

        assertTrue(racingHistory.keys.toList().size == carNames.split(",").size)
    }

    @Test
    fun `자동차 경주 시도 횟에 따른 이동 히스토리 생성 테스트`() {
        val carNames = "자동차1,자동차2,자동차3"
        val tryCount = 5

        val racingHistory = RacingCar(carNames, tryCount).start(ForwardStrategy.CarForward)

        assertTrue(racingHistory.values.toList()[0].size == tryCount)
    }
}
