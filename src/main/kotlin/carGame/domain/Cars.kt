package carGame.domain

class Cars(val cars: List<Car>) {
    fun moveBy(movable: () -> Boolean): Cars {
        val positions = this.cars.map { if (movable()) it.move() else it }
        return Cars(positions)
    }

    companion object {
        fun atZeroPosition(carNames: List<CarName>): Cars {
            val cars = carNames.map { Car.atZeroPosition(it) }
            return Cars(cars)
        }
    }
}
