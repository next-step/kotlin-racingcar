package racingcar.controller

import racingcar.domain.car.Car
import racingcar.domain.car.Cars
import racingcar.domain.car.action.RandomMovingStrategy
import racingcar.view.InputView
import racingcar.view.ResultView

class Controller {
    fun start() {
        val cars = inputRacers()
        val playTime = inputPlayTime()
        ResultView.printResultTitle()
        repeat(playTime) {
            cars.play(RandomMovingStrategy())
            ResultView.printResult(cars)
        }
    }

    private fun inputRacers(): Cars {
        return try {
            val inputRacers = InputView.inputRacers()
            Cars(inputRacers.map { Car(it) })
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputRacers()
        }
    }

    private fun inputPlayTime(): Int {
        return try {
            InputView.inputPlayTime()
        } catch (e: Exception) {
            InputView.printError(e.message!!)
            inputPlayTime()
        }
    }
}
