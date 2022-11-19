package racing.domain

class Winner(cars: Cars) {

    var cars = cars
        private set

    constructor(carList: List<Car>) : this(Cars(carList))

    fun win(): String {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }.joinToString { it.name }
    }
}
