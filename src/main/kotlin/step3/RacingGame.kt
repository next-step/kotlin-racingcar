package step3

import step3.domain.Car
import step3.domain.Cars
import step3.view.InputView
import step3.view.ResultView

class RacingGame {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputData = InputView.setInputData()
            val cars = Cars(Array(inputData.first) { Car() }.toList())
            ResultView.printResultTitle()
            repeat(inputData.second) {
                cars.play()
                ResultView.printResult(cars)
            }
        }
    }
}
