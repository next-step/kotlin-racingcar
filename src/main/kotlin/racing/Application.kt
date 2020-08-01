package racing

import racing.domain.RacingState
import racing.infrastructure.RacingGame
import racing.presentation.InputView
import racing.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputNames = InputView().inputNames()
        val attempt = InputView().inputAttempt()

        val names = InputView().splitNames(inputNames)

        val racingState = RacingState(names, attempt.toInt())
        val result = RacingGame().start(racingState)

        val winners = RacingGame().getWinners(result)
        ResultView().show(result)
        ResultView().showWinner(winners)
    }
}
