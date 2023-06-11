package race.controller

import race.Car
import race.Race
import race.view.InputView
import race.view.ResultView

class RaceController {
    fun run() {
        val inputView = InputView()
        val inputData = inputView.input()

        val numberOfCar = inputData.numberOfCar
        val numberOfTry = inputData.numberOfTry

        val cars = mutableListOf<Car>()
        repeat(numberOfCar) {
            cars.add(Car())
        }

        val result = Race(cars, numberOfTry).run()

        ResultView().run(result)
    }
}

fun main() {
    RaceController().run()
}
