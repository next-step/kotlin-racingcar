package game.domain

class DefaultWinnerFinder : WinnerFinder {
    override fun findWinner(cars: List<Car>): List<String> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.isSamePosition(maxPosition) }.map { it.name }
    }
}
