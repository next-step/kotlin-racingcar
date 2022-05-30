package racingcar

import racingcar.repository.CarRepository
import racingcar.service.RangeRandomGenerator
import racingcar.view.InputView
import racingcar.view.ResultView

private val inputView: InputView = InputView()
private val resultView: ResultView = ResultView()
private val racingGameService: RacingCarService = RacingCarService(
    CarRepository(),
    RangeRandomGenerator()
)

fun main() {
    val (numberOfCars, numberOfTries) = inputView.receiveRequest()
    val gameResult = racingGameService.playGame(numberOfCars, numberOfTries)

    resultView.printResult(gameResult)
}
