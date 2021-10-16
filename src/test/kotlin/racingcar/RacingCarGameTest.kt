package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.mock.AddCountWhenCallIsForwardRacingCarCondition
import racingcar.mock.NoOutputView
import racingcar.model.CarCount
import racingcar.model.GameCount
import racingcar.view.InputView

class RacingCarGameTest {

    @Test
    fun `차량 대수와 게임 횟수만큼 전진 가능 호출 횟수 확인`() {
        // given
        val carCount = CarCount(3)
        val gameCount = GameCount(5)
        val inputView = object : InputView {
            override fun getCarCount(): CarCount = carCount
            override fun getGameCount(): GameCount = gameCount
        }
        val outputView = NoOutputView()
        val condition = AddCountWhenCallIsForwardRacingCarCondition()
        val racingCarGame = RacingCarGame(inputView, outputView, condition)

        // when
        val expected = carCount.count * gameCount.count
        racingCarGame.startGame()
        val actual = condition.count

        Assertions.assertEquals(expected, actual)
    }
}
