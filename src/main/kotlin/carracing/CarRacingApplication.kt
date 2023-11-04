package carracing

import carracing.view.InputType
import carracing.view.InputView
import carracing.view.ResultView

fun main() {
    val inputView = InputView()
    val racingCarNames = inputView.inputString(InputType.RACING_NAMES)
    val racingCount = inputView.inputCount(InputType.RACING_COUNT)

    val carNames = racingCarNames.split(",")
    CarRacingValidator().validateCarNames(carNames)

    val racingGame = RacingGame(carNames, racingCount, RandomGame())
    val racingResult = racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingResult)
    resultView.printWinners(racingResult.last().roundResult)
}
