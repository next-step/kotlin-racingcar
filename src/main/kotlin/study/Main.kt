package study

import study.step3.InputView
import study.step3.RacingCarGame
import study.step3.RacingRequest
import study.step3.ResultView

fun main() {
    val racingRequest = RacingRequest(
        InputView.requestCarCount(),
        InputView.requestTryCount()
    )

    val game = RacingCarGame(racingRequest)
    game.play(racingRequest)

    val carList = game.getCurrentCars()
    ResultView.showResult(racingRequest.tryCount, carList)
}
