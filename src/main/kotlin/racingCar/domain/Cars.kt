package racingCar.domain

class Cars(carNumber: Int, private val strategy: MoveStrategy) {

    val cars: List<Car> = List(carNumber) { Car() }

    fun moveByStrategy() {
        cars.forEach {
            moveByStrategy(it)
        }
    }

    private fun moveByStrategy(car: Car) {
        if (!strategy.canMove()) {
            return
        }
        car.move()
    }
}
