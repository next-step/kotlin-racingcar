package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.view.InputView.register
import racingcar.view.ResultView
import racingcar.view.ResultView.executionResult
import racingcar.view.ResultView.presentSituation

object RacingGameController {

    fun run() {
        val register = register()
        executionResult()
        val raceResult = RacingGame.race(register, register.times) { presentSituation(it.name, it.currentPosition) }
        ResultView.presentWinner(raceResult.cars)
    }
}
