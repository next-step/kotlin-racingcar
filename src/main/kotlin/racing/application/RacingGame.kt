package racing.application

import racing.domain.Car
import racing.domain.Cars
import racing.domain.RandomStrategy
import racing.ui.OutputView

class RacingGame(
    val tryCount: Int,
    val numberOfCar: Int
) {

    private val carMoveStrategy = RandomStrategy()

    fun runRace() {
        val cars = Cars(List(numberOfCar) { Car() })

        OutputView.printOutputLetter()

        repeat(tryCount) {
            cars.tryMoveCars(carMoveStrategy.carMove(tryCount))
            OutputView.printCarCollection(cars.getCarsPosition())
        }
    }
}
