package car_race

import car_race.logic.system.RandomMovingSystem
import car_race.view.InputView
import car_race.view.ResultView

fun main() {
    val cars = InputView.inputCars()
    val gameRound = InputView.inputGameRound()

    ResultView.resultViewStart()
    for (i in 1..gameRound.value) {
        ResultView.printEachRound(cars)
        cars.nextRound(RandomMovingSystem)
    }
    ResultView.printWinners(cars)
}
