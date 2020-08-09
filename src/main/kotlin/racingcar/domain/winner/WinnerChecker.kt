package racingcar.domain.winner

import racingcar.domain.car.Car

class WinnerChecker {
    fun findWinners(cars: List<Car>): List<Car> {
        return cars.sortByDistance().filterAllFirst()
    }

    fun List<Car>.sortByDistance(): List<Car> = sortedByDescending { it.distance }

    fun List<Car>.filterAllFirst(): List<Car> = takeWhile { it.distance == this.first().distance }
}
