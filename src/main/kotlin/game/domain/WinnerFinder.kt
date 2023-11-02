package game.domain

class WinnerFinder {
    fun findWinner(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.isSamePosition(maxPosition) }.map { it.name }
    }
}
