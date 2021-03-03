package racingcar

import racingcar.domain.RacingCarGame
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val carCount = inputView.readInt("자동차 대수는 몇 대인가요?")
    val attemptCount = inputView.readInt("시도할 횟수는 몇 회인가요?")
    ResultView(
        RacingCarGame(carCount = carCount).play(attemptCount = attemptCount)
    ).print()
}
