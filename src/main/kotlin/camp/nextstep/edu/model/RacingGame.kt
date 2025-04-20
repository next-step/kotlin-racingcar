package camp.nextstep.edu.model

object RacingGame {
    fun playRound(cars: List<Car>) {
        cars.forEach(::tryMoveCar)
    }
    fun getCarPositions(cars: List<Car>): List<String> = cars.map(Car::displayPosition)

    fun findWinners(cars: List<Car>): List<Car> {
        val maxPosition = getMaxPosition(cars)
        return filterWinnerByPosition(cars, maxPosition)
    }

    private fun tryMoveCar(car: Car) {
        car.move()
    }

    private fun getMaxPosition(cars: List<Car>): Int = cars.maxOfOrNull { it.position } ?: 0
    private fun filterWinnerByPosition(cars: List<Car>, maxPosition: Int): List<Car> =
        cars.filter { it.position == maxPosition }

}
