package racingcar.domain

class Cars(val cars: List<Car>) {

    val namesAndPositions: List<Pair<String, Int>>
        get() {
            return cars.map { Pair(it.carName.name, it.position) }
        }

    val winners: List<Car>
        get() {
            val maxPosition = cars.maxOf { it.position }
            return cars.filter { it.position == maxPosition }
        }

    fun moveAllCars() {
        for (car in cars) {
            moveCar(car)
        }
    }

    private fun moveCar(car: Car) {
        car.move()
    }
}
