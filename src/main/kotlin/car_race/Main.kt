package car_race

import car_race.view.InputView
import car_race.view.ResultView

fun main() {
    val gameRound = InputView.inputGameRound()
    val cars = InputView.inputCarCount()

    for (i in 1..gameRound.value) {
        ResultView.printEachRound(cars)
        cars.nextRound()
        println()
    }
}
