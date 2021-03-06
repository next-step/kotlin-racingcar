package racing.domain

import racing.data.CarState

class Cars(names: List<String>) {

    val cars: List<Car> = names.map { Car(it) }

    fun getFarthestCars(): List<Car> {
        val maxPosition = getMaxPosition()
        return cars.filter { it.position == maxPosition }
    }

    private fun getMaxPosition(): CarPosition {
        val maxPosition = cars.maxBy { it.position }?.position
        return maxPosition ?: CarPosition.INIT_POSITION
    }

    fun moveAllCar(movementChecker: MovementChecker) {
        cars.filter { movementChecker.isMovable() }
            .forEach { it.moveCar() }
    }

    fun getCarStates(): List<CarState> {
        return cars.map { CarState.from(it) }
    }
}
