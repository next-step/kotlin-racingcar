package race.model

class Race(
    private val numberOfCar: Int,
) {

    companion object {
        const val MOVING_NUMBER = 4
    }

    private val _cars = mutableListOf<Car>().apply {
        repeat(numberOfCar) {
            add(Car())
        }
    }

    val cars: List<Car> get() = _cars

    fun carsMove() {
        _cars.forEach {
            go(it)
        }
    }

    fun go(car: Car = _cars[0], number: Int = (0..9).random()) {
        if (number >= MOVING_NUMBER) {
            car.move()
        }
    }
}
