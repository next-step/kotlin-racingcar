package racing.application

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RandomStrategy
import racing.ui.OutputView

class RacingGame(
    val tryCount: Int,
    val numberOfCar: Int
) {

    fun runRace() {
        val cars = Cars(List(numberOfCar) { Car() }, RandomStrategy())
        OutputView.printTitle()

        repeat(tryCount) {
            cars.tryMoveCars()
            OutputView.printCarPosition(cars.getCarsPosition())
        }
    }
}
