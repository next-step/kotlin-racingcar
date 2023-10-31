package racing.car

import racing.moveprovider.RandomMoveProvider
import racing.ui.ResultViewAction

class CarRace {
    fun randomMove(cars: Cars, tryNumber: Int, resultViewAction: ResultViewAction) {
        for (i in 1..tryNumber) {
            cars.moveAll(RandomMoveProvider())
            resultViewAction(cars)
        }
    }
}
