package racingcar.controller

import racingcar.domain.RacingGame
import racingcar.domain.RandomGearFactory
import racingcar.view.InputView
import racingcar.view.ResultView

object RacingGameController {

    fun run() {
        val register = InputView.register()
        ResultView.executionResult()
        val raceResult =
            RacingGame.race(register, register.times, RandomGearFactory) {
                ResultView.presentSituation(
                    it.name,
                    it.currentPosition
                )
            }
        ResultView.presentWinner(raceResult.winnerCars)
    }
}
