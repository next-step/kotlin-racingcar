package domain

import view.InputView
import view.ResultView

class RacingCarController {
    fun start() {
        val inputCommand = InputView().input()
        val cars = CarGame().startGame(inputCommand)
        //ResultView().printResult(inputCommand, cars)
    }
}