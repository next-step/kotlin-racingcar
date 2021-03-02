package racing.domain

import racing.data.CarState

class Cars(private val movementChecker: MovementChecker) {

    private var cars = listOf<Car>()

    fun createNewCars(names: List<String>) {
        cars = names.map { Car(it) }.toList()
    }

    fun getFarthestCars(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    private fun getMaxPosition(): CarPosition {
        val maxPosition = cars.maxBy { it.position }?.position
        return maxPosition ?: CarPosition.INIT_POSITION
    }

    fun moveAllCar() {
        cars.forEach {
            if (movementChecker.isMovable()) {
                it.moveCar()
            }
        }
    }

    fun getCarStates(): List<CarState> {
        return cars.map { CarState.of(it) }.toList()
    }

    fun size() = cars.size

    fun names() = cars.map { it.name }.toList()
    fun positions() = cars.map { it.position }.toList()

    operator fun get(index: Int) = cars[index]
}
