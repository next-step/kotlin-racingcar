package racingcar.racing.winner

import racingcar.racing.car.Car
import racingcar.racing.const.WINNER_IS
import racingcar.racing.const.WINNER_SEPARATOR
import racingcar.racing.view.View

class WinnerChecker {
    fun findWinners(cars: List<Car>): List<Car> {
        return cars.sortByDistance().filterAllFirst()
    }

    fun winnerToString(winners: List<Car>): String {
        return winners
            .joinToString(separator = WINNER_SEPARATOR, postfix = WINNER_IS) { it.name }
    }

    fun rewardWinner(cars: List<Car>, view: View) {
        view.print(winnerToString(findWinners(cars)))
    }

    fun List<Car>.sortByDistance(): List<Car> = sortedByDescending { it.distance }

    fun List<Car>.filterAllFirst(): List<Car> = takeWhile { it.distance == this.first().distance }
}
