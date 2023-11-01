package racing.car

import racing.moveprovider.RandomMoveProvider

class CarRace {
    fun start(cars: Cars, tryNumber: Int, moveProvider: RandomMoveProvider): MutableList<Cars> {
        val roundsResults = mutableListOf<Cars>()
        repeat(tryNumber) {
            cars.moveAll(moveProvider)
            val copiedCars = cars.copy()
            roundsResults.add(copiedCars)
        }
        return roundsResults
    }
}
