package src.racingcar

import src.racingcar.domain.CarService
import src.racingcar.view.InputView
import src.racingcar.view.ResultView

object RacingCarGame {
    fun startGame() {
        val inputValue = InputView.executeInputScreen()
        val raceCars = CarService(getCarMoveRandomValue()).execute(inputValue.carNames)
        ResultView.printRacingCarGameResult(inputValue.tryCount, raceCars)
    }
}

fun main() {
    RacingCarGame.startGame()
}
