package racingcar

import racingcar.repository.CarRepository
import racingcar.service.RangeRandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

private val racingGameService: RacingCarService = RacingCarService(
    CarRepository(),
    RangeRandomGenerator()
)

fun main() {
    val (numberOfCars, numberOfTries) = InputView.receiveRequest()
    val gameResult = racingGameService.playGame(numberOfCars, numberOfTries)

    ResultView.printResult(gameResult)
}
