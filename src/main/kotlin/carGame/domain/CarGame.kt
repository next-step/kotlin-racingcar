package carGame.domain

import carGame.domain.strategy.MoveStrategy

class CarGame(private val moveStrategy: MoveStrategy) {
    fun play(carNames: List<CarName>, tryCount: Int): GameResult {
        val initialCars = Cars.atZeroPosition(carNames)
        val history = playRounds(initialCars, tryCount)
        return GameResult(history)
    }

    private fun playRounds(initialCars: Cars, tryCount: Int): List<Cars> {
        val history = mutableListOf(initialCars)
        repeat(tryCount) {
            val roundHistory = playRound(history.last())
            history.add(roundHistory)
        }
        history.removeFirst()
        return history
    }

    private fun playRound(cars: Cars): Cars {
        return cars.moveBy { moveStrategy.movable() }
    }
}
