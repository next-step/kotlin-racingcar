package racing.application

import racing.domain.Car
import racing.domain.CarName
import racing.domain.Cars
import racing.domain.RandomStrategy
import racing.ui.OutputView.printCarNameAndPosition
import racing.ui.OutputView.printTitle
import racing.ui.OutputView.printWinnerCars

class RacingGame(
    val tryCount: Int,
    val carNames: List<String>
) {

    fun runRace() {
        val cars = Cars(carNames.map { Car(CarName(it)) }, RandomStrategy())
        printTitle()

        repeat(tryCount) {
            cars.tryMoveCars()
            printCarNameAndPosition(cars)
        }
        printWinnerCars(cars.winner())
    }
}
