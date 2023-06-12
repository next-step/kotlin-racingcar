package racingcar.domain

import racingcar.view.OutputView
import racingcar.view.OutputViewProtocol

class Round(private val outputView: OutputViewProtocol) {


    fun execute(cars: ArrayList<Car>) {
        controlEachCar(cars)
        printRound(cars)
    }

    private fun controlEachCar(cars: ArrayList<Car>) {
        for (car in cars) {
            car.isMoveOrStop()
        }
    }

    private fun printRound(cars: ArrayList<Car>) {
        for (car in cars) {
            outputView.printValue(car.getLocation())
        }
    }
}
