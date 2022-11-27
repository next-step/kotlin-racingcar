package carrace

import carrace.logic.car.Cars
import carrace.logic.system.RandomMovingSystem
import carrace.view.InputView
import carrace.view.ResultView

fun main() {
    val cars = InputView.inputCars()
    val gameRound = InputView.inputGameRound()

    val gameLogs = mutableListOf<Cars>()
    for (i in 1..gameRound.value) {
        gameLogs.add(
            cars.nextRound(RandomMovingSystem)
        )
    }

    ResultView.printGameResult(gameLogs)
}
