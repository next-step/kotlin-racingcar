package racingcar.domain

class Cars {

    companion object {
        private val MOVEMENT_STRATEGY: MovementStrategy = RandomNumberMovementStrategy()
    }

    private val cars: List<Car>

    constructor(numberOfCars: Int) {
        cars = List(numberOfCars) { Car() }
    }

    fun racing() {
        cars.forEach {
            it.move(MOVEMENT_STRATEGY)
        }
    }
}
