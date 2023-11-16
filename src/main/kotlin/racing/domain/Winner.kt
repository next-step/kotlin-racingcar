package racing.domain

object Winner {
    fun findWinners(cars: List<Car>): List<Car> {
        val fastestPosition = cars.maxBy { it.position }.position
        return cars.filter { it.isFastestPosition(fastestPosition) }
    }
}
