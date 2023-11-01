package racing.car

import racing.moveprovider.RandomMoveProvider
import racing.ui.ResultViewAction

class CarRace {
    fun start(cars: Cars, tryNumber: Int, moveProvider: RandomMoveProvider, resultViewAction: ResultViewAction): Cars {
        repeat(tryNumber) {
            cars.moveAll(moveProvider)
            resultViewAction(cars)
        }
        return cars
    }
}
