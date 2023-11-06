package racingcar.controller

import racingcar.model.RacingCarGame
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingCarController {
    fun startGame() {
        val namesOfCars = InputView.getNamesOfCars()
        val numbersOfTry = InputView.getNumbersOfTry()
        val game = RacingCarGame.ofCarNames(namesOfCars)
        ResultView.printInitial()
        val gameResult = game.run(numbersOfTry)
        ResultView.printResult(gameResult)
        ResultView.printWinner(gameResult.getWinners())
    }
}
