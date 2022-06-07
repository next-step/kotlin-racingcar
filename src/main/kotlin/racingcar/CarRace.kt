package racingcar

import racingcar.domain.car.Cars
import racingcar.domain.move.RandomMovingStrategy
import racingcar.view.ConsoleInput
import racingcar.view.ConsoleOutput
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRace(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val movingStrategy = RandomMovingStrategy()
        val cars = Cars.of(inputView.askCarNames())
        val trialCount = inputView.askCountOfTrial()
        val carRaceResult = cars.move(movingStrategy, trialCount)
        outputView.printCarRace(carRaceResult)
    }
}

fun main() {
    val carRace = CarRace(ConsoleInput(), ConsoleOutput())
    carRace.run()
}
