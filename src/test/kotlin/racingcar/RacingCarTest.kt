package racingcar

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `자동차 경주 자동차 생성 테스트`() {
        val carNames = "자동차1,자동차2,자동차3"

        val racingHistory = RacingCar(carNames, 1).start(ForwardStrategy.DefaultForward)

        assertTrue(racingHistory.getMoveHistory().size == carNames.split(",").size)
    }

    @Test
    fun `자동차 경주 시도 횟에 따른 이동 히스토리 생성 테스트`() {
        val carNames = "자동차1,자동차2,자동차3"
        val tryCount = 5

        val racingHistory = RacingCar(carNames, tryCount).start(ForwardStrategy.DefaultForward)

        assertTrue(racingHistory.getMoveHistory().values.toList()[0].size == tryCount)
    }

    @Test
    fun `자동차 이름은 쉼표(,)를 기준으로 구분한다`() {
        val carNames = "자동차1,자동차2,자동차3"
        val tryCount = 1

        val racingHistory = RacingCar(carNames, tryCount).start(ForwardStrategy.DefaultForward)

        assertTrue(racingHistory.getMoveHistory().size == carNames.split(",").size)
    }

    @Test
    fun `자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다, 우승자는 한 명 이상일 수 있다`() {
        val carNames = "자동차1,자동차2,자동차3"
        val tryCount = 1
        val racingCar = RacingCar(carNames, tryCount)

        val moveHistory = racingCar.start(ForwardStrategy.DefaultForward)

        assertTrue(moveHistory.getWinningCarNames().isNotEmpty())
    }
}
