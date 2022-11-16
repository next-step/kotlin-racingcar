package racingcar.controller

import racingcar.domain.Game
import racingcar.view.InputView
import racingcar.view.ResultView

class CarController {
    fun run() {
        val (carNames, numberOfTry) = InputView.read()
        val game = Game(carNames, numberOfTry)
        val gameResult = game.execute()
        ResultView.print(gameResult)
    }
}
