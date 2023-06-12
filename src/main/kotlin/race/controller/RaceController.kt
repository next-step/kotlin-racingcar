package race.controller

import race.model.Car
import race.model.Race
import race.model.RandomMoveCondition
import race.view.InputView
import race.view.ResultView

class RaceController {
    fun run() {
        val inputView = InputView()
        val inputData = inputView.input()

        val carNames = inputData.carNames
        val numberOfTry = inputData.numberOfTry

        val cars = mutableListOf<Car>()
        val condition = RandomMoveCondition()
        cars.addAll(carNames.map { carName -> Car(carName, condition) })

        val result = Race().run(cars, numberOfTry)

        ResultView().run(result)
    }
}

fun main() {
    RaceController().run()
}
