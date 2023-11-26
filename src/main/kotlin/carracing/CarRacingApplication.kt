package carracing

import carracing.domain.CarRacingValidator
import carracing.controller.RacingGame
import carracing.view.InputType
import carracing.view.InputView
import carracing.view.ResultView

fun main() {
    val inputView = InputView(CarRacingValidator())
    val carNames = inputView.inputNames(InputType.RACING_NAMES)
    val racingCount = inputView.inputCount(InputType.RACING_COUNT)

    val racingGame = RacingGame(carNames, racingCount)
    val racingResult = racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingResult)
    resultView.printWinners(racingResult.last().roundResult)
}
