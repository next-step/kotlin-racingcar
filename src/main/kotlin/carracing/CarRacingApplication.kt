package carracing

import carracing.domain.RacingGame
import carracing.domain.RandomGame
import carracing.view.InputType
import carracing.view.InputView
import carracing.view.ResultView

fun main() {
    val inputView = InputView()
    val carNames = inputView.inputString(InputType.RACING_NAMES)
    val racingCount = inputView.inputCount(InputType.RACING_COUNT)

    val racingGame = RacingGame(carNames, racingCount, RandomGame())
    val racingResult = racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingResult)
    resultView.printWinners(racingResult.last().roundResult)
}
