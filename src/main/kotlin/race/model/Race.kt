package race.model

class Race(
    private val numberOfCar: Int,
) {

    private val _cars = mutableListOf<Car>().apply {
        repeat(numberOfCar) {
            add(Car())
        }
    }

    val cars: List<Car> get() = _cars.toList()

    fun carsMove() {
        _cars.forEach {
            it.go()
        }
    }
}
