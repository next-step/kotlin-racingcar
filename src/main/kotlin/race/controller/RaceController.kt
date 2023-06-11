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
        for (carName in carNames) {
            cars.add(Car(carName, condition))
        }

        val result = Race(cars, numberOfTry).run()

        ResultView().run(result)
    }
}

fun main() {
    RaceController().run()
}
