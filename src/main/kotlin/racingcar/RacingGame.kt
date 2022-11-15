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
            val racers = InputView.inputRacers()
            val cars = Cars(racers.map { Car(it) })
            val playTime = InputView.inputPlayTime()
            ResultView.printResultTitle()
            repeat(playTime) {
                cars.play(RandomMovingStrategy())
                ResultView.printResult(cars)
            }
        }
    }
}
