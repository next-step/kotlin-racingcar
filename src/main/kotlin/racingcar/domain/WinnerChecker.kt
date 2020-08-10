package racingcar.domain

class WinnerChecker {
    fun findWinners(cars: List<Car>): List<Car> {
        val longest = cars.longestDistance()
        return cars.filter { it.isIn(longest) }
    }

    private fun List<Car>.longestDistance(): Int {
        return maxBy { it.distance }?.distance ?: 0
    }
}
