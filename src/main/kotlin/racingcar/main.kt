package racingcar

import racingcar.service.RangeRandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

private val racingGameService: RacingCarService = RacingCarService(
    RangeRandomGenerator(),
)

fun main() {
    val (carNames, numberOfTries) = InputView.receiveRequest()
    val gameResult = racingGameService.playGame(carNames, numberOfTries)

    ResultView.printResult(gameResult)
}
