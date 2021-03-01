package racing.domain

class RacingGame(carCount: Int, var movementChecker: MovementChecker) {

    val cars = mutableListOf<Car>()

    init {
        repeat(carCount) {
            cars.add(Car())
        }
    }

    fun moveAllCar() {
        cars.forEach { moveCarIfPossible(it) }
    }

    private fun moveCarIfPossible(car: Car) {
        if (movementChecker.isMovable()) {
            car.moveCar()
        }
    }

    fun getCarPositions(): List<Int> {
        return cars.map { it.position }
    }
}
