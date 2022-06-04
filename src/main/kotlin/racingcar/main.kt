package racingcar

import racingcar.repository.CarRepository
import racingcar.service.RangeRandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

private val racingGameService: RacingCarService = RacingCarService(
    CarRepository(),
    RangeRandomGenerator(),
)

fun main() {
    val (carNames, numberOfTries) = InputView.receiveRequest()
    val gameResult = racingGameService.playGame(carNames, numberOfTries)

    ResultView.printResult(gameResult)
}
