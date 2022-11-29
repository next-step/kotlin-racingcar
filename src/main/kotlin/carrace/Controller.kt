package carrace

import carrace.logic.car.CarInfos
import carrace.logic.system.RandomMovingSystem
import carrace.view.InputView
import carrace.view.ResultView

class Controller(
    private val inputView: InputView,
    private val resultView: ResultView
) {

    fun startGame() {
        val cars = inputView.inputCars()
        val gameRound = inputView.inputGameRound()

        val gameLog = mutableListOf(CarInfos(cars))

        if (gameRound.value > 1) {
            for (i in 1..gameRound.value) {
                gameLog.add(
                    cars.nextRound(RandomMovingSystem)
                )
            }
        }

        resultView.displayGameResult(gameLog)

        val winners = cars.getWinners()
        resultView.displayWinner(CarInfos(winners))
    }
}
