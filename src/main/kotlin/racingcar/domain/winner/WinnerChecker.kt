package racingcar.domain.winner

import racingcar.domain.car.Car
import racingcar.domain.const.WINNER_IS
import racingcar.domain.const.WINNER_SEPARATOR
import racingcar.domain.result.RacingResult

class WinnerChecker {
    fun findWinners(cars: List<Car>): List<Car> {
        return cars.sortByDistance().filterAllFirst()
    }

    fun winnerToString(results: List<RacingResult>): String {
        return findWinners(results.getLastResults()).toPrintable()
    }

    private fun List<RacingResult>.getLastResults(): List<Car> {
        return last().cars
    }

    private fun List<Car>.toPrintable(): String {
        return joinToString(separator = WINNER_SEPARATOR, postfix = WINNER_IS) { it.name }
    }

    fun List<Car>.sortByDistance(): List<Car> = sortedByDescending { it.distance }

    fun List<Car>.filterAllFirst(): List<Car> = takeWhile { it.distance == this.first().distance }
}
