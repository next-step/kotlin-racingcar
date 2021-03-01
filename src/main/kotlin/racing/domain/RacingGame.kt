package racing.domain

class RacingGame(carNames: List<String>, var movementChecker: MovementChecker) {

    val cars = mutableListOf<Car>()

    init {
        for (name in carNames) {
            cars.add(Car(name))
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

    fun getWinners(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    private fun getMaxPosition(): Int {
        val maxPosition = cars.maxBy { it.position }?.position
        return maxPosition ?: 0
    }
}
