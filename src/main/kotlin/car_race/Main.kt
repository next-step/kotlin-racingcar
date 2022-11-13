package car_race

import car_race.logic.system.RandomMovingSystem
import car_race.view.InputView
import car_race.view.ResultView

fun main() {
    val gameRound = InputView.inputGameRound()
    val cars = InputView.inputCarCount()

    val movingSystem = RandomMovingSystem
    for (i in 1..gameRound.value) {
        ResultView.printEachRound(cars)
        cars.nextRound(movingSystem)
        println()
    }
}
