package racing.controller

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RandomStrategy
import racing.view.InputView
import racing.view.OutputView.printCarNameAndPosition
import racing.view.OutputView.printTitle
import racing.view.OutputView.printWinnerCars

class RacingGame {
    fun runRace() {
        val carNames = InputView.getCarNames()
        val tryCount = InputView.getTryCount()

        val cars = Cars(carNames.map { Car(it) }, RandomStrategy())
        printTitle()

        repeat(tryCount) {
            cars.tryMoveCars()
            printCarNameAndPosition(cars)
        }
        printWinnerCars(cars.winner())
    }
}
