package race

import race.controller.RaceController
import race.view.ResultView

class Race(
    private val cars: List<Car>,
    private val numberOfTry: Int
) {
    private val resultView = ResultView()

    fun run() {
        println("실행 결과")

        repeat(numberOfTry) {
            cars.forEach { it.move() }
            resultView.showAllPosition(cars)
        }
    }
}

fun main() {
    val raceRequest = RaceController().run()

    val cars = raceRequest.cars
    val numberOfTry = raceRequest.numberOfTry

    Race(cars, numberOfTry).run()
}
