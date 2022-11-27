package carrace

import carrace.logic.system.RandomMovingSystem
import carrace.view.InputView
import carrace.view.ResultView

class Controller {

    fun startGame() {
        val cars = InputView.inputCars()
        val gameRound = InputView.inputGameRound()

        val gameLogs = mutableListOf(cars)
        for (i in 1..gameRound.value) {
            gameLogs.add(
                gameLogs.last().nextRound(RandomMovingSystem)
            )
        }

        ResultView.printGameResult(gameLogs)
    }
}
