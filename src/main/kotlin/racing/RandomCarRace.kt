package racing

import kotlin.random.Random

class RandomCarRace {
    fun move(cars: Cars, tryNumber: Int, resultViewAction: (Cars) -> Unit) {
        for (i in 1..tryNumber) {
            cars.moveAll { Random.nextInt(10 ) }
            resultViewAction(cars)
        }
    }
}