package racing

import racing.moveprovider.RandomMoveProvider

class CarRace {
    fun randomMove(cars: Cars, tryNumber: Int, resultViewAction: (Cars) -> Unit) {
        for (i in 1..tryNumber) {
            cars.moveAll(RandomMoveProvider())
            resultViewAction(cars)
        }
    }
}