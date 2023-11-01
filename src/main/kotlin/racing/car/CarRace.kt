package racing.car

import racing.moveprovider.RandomMoveProvider
import racing.ui.ResultViewAction

class CarRace {
    fun randomMove(cars: Cars, tryNumber: Int, resultViewAction: ResultViewAction): Cars {
        repeat(tryNumber) {
            cars.moveAll(RandomMoveProvider())
            resultViewAction(cars)
        }
        return cars
    }
}
