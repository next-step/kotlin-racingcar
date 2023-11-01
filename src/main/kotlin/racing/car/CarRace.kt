package racing.car

import racing.moveprovider.RandomMoveProvider
import racing.ui.ResultViewAction

class CarRace {
    fun randomMove(cars: Cars, tryNumber: Int, resultViewAction: ResultViewAction) {
        repeat(tryNumber) {
            cars.moveAll(RandomMoveProvider())
            resultViewAction(cars)
        }
    }
}
