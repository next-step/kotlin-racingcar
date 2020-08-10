package racingcar.domain

class WinnerChecker {
    fun findWinners(cars: List<Car>): List<Car> {
        return cars.sortByDistance().filterAllFirst()
    }

    private fun List<Car>.sortByDistance(): List<Car> = sortedByDescending { it.distance }

    private fun List<Car>.filterAllFirst(): List<Car> = takeWhile { it.distance == this.first().distance }
}
