package racingcar

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.action.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

class RacingGame {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputData = InputView.inputData()
            val cars = Cars(Array(inputData.getNumberOfCars) { Car("pobi") }.toList())
            ResultView.printResultTitle()
            repeat(inputData.getPlayTime) {
                cars.play(RandomMovingStrategy())
                ResultView.printResult(cars)
            }
        }
    }
}
