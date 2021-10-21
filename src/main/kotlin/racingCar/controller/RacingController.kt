package racingCar.controller

import racingCar.model.Cars
import racingCar.view.InputView
import racingCar.view.ResultView

class RacingController(private val inputView: InputView, private val resultView: ResultView) {

    fun start() {
        val (numberOfCars, numberOfTrial) = inputView.inputData()

        val cars = Cars(numberOfCars)
        repeat(numberOfTrial) {
            cars.move()
            resultView.show(cars, numberOfTrial)
        }

        resultView.victoryPlayer(cars)
    }
}
