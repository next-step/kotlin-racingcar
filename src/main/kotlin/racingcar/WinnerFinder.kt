package racingcar

import racingcar.dtos.GameResult

class WinnerFinder {
    fun find(gameResult: GameResult): List<Car> {
        val lastRoundResult = gameResult.roundResults.last()
        val maxPosition = lastRoundResult.cars.maxOf { it.position }
        return lastRoundResult.cars.filter { it.position == maxPosition }
    }
}
