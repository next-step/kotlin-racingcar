package car_race

import car_race.logic.car.Cars
import car_race.logic.system.RandomMovingSystem
import car_race.view.InputView
import car_race.view.ResultView

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
