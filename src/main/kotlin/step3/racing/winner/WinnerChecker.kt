package step3.racing.winner

import step3.racing.car.Car
import step3.racing.const.WINNER_IS
import step3.racing.const.WINNER_SEPERATOR
import step3.racing.view.View

class WinnerChecker {
    fun findWinners(cars: List<Car>): List<Car> {
        return cars.sortByDistance().filterAllFirst()
    }

    fun winnerToString(winners: List<Car>): String {
        return winners
            .joinToString(separator = WINNER_SEPERATOR, postfix = WINNER_IS) { it.name }
    }

    fun rewardWinner(cars: List<Car>, view: View) {
        view.print(winnerToString(findWinners(cars)))
    }

    fun List<Car>.sortByDistance(): List<Car> = sortedByDescending { it.distance }

    fun List<Car>.filterAllFirst(): List<Car> = takeWhile { it.distance == this.first().distance }
}
