package racing.application

import racing.domain.Car
import racing.domain.CarMoveStrategy
import racing.domain.Cars
import racing.domain.RandomStrategy
import racing.ui.OutputView

class RacingGame(
    val tryCount: Int,
    val numberOfCar: Int
) {

    private val carMoveStrategy: CarMoveStrategy = RandomStrategy()

    fun runRace() {
        val cars = Cars(List(numberOfCar) { Car() })

        OutputView.printTitle()

        repeat(tryCount) {
            cars.tryMoveCars(carMoveStrategy.values(tryCount))
            OutputView.printCarPosition(cars.getCarsPosition())
        }
    }
}
