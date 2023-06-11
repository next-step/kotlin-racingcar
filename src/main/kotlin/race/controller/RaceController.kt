package race.controller

import race.Car
import race.view.InputView

class RaceController {
    fun run(): RaceRequest {
        val inputView = InputView()
        val inputData = inputView.input()

        val numberOfCar = inputData.numberOfCar
        val numberOfTry = inputData.numberOfTry

        val cars = mutableListOf<Car>()
        repeat(numberOfCar) {
            cars.add(Car())
        }

        return RaceRequest(numberOfTry, cars)
    }
}
