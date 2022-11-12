package step3

import step3.domain.car.Car
import step3.domain.car.Cars
import step3.view.InputView
import step3.view.ResultView

class RacingGame {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputData = InputView.inputData()
            val cars = Cars(Array(inputData.getNumberOfCars()) { Car() }.toList())
            ResultView.printResultTitle()
            repeat(inputData.getPlayTime()) {
                cars.play()
                ResultView.printResult(cars)
            }
        }
    }
}
