package racing.domain

class Winner(cars: Cars) {

    var cars = cars
        private set

    constructor(carList: List<Car>) : this(Cars(carList.map { it.name }.joinToString(",")))

    fun win(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
