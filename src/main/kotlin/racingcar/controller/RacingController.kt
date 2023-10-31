package racingcar.controller

import racingcar.model.Games
import racingcar.model.RandomMovement
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingController {
    fun start() {
        val racingGame = Games.of(InputView.inputCarList(), RandomMovement())
        val gameCount = InputView.inputGameCount()

        ResultView.printHeader()
        repeat(gameCount) {
            ResultView.showProgress(racingGame.play())
        }
        ResultView.showWinner(racingGame.getWinner())
    }
}
