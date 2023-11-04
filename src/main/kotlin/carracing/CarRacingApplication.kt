package carracing

import carracing.view.InputType
import carracing.view.InputView
import carracing.view.ResultView

fun main() {
    val inputView = InputView()
    val carCount = inputView.inputCount(InputType.CAR_COUNT)
    val racingCount = inputView.inputCount(InputType.RACING_COUNT)

    val racingGame = RacingGame(carCount, racingCount, RandomGame())
    val racingResult = racingGame.start()

    val resultView = ResultView()
    resultView.printResult(racingResult)
}
