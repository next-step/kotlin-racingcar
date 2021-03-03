package racing.domain

import racing.data.CarState

class Cars(names: List<String>, private val movementChecker: MovementChecker) {

    val cars: List<Car> = names.map { Car(it) }

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
        return cars.map { CarState.from(it) }
    }
}
