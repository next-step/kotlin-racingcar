package racing

import racing.infrastructure.RacingGame
import racing.domain.RacingState
import racing.domain.Winner
import racing.util.CarUtil
import racing.presentation.InputView
import racing.presentation.ResultView

object Application {
    @JvmStatic
    fun main(args: Array<String>) {
        val inputNames = InputView().inputNames()
        val attempt = InputView().inputAttempt()

        CarUtil.validate(inputNames, attempt)

        val names = CarUtil.splitNames(inputNames)

        val racingState = RacingState(names, attempt.toInt())
        val result = RacingGame().start(racingState)

        val winners = Winner().get(result)
        ResultView().show(result)
        ResultView().showWinner(winners)
    }
}
