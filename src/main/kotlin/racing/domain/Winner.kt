package racing.domain

class Winner(cars: Cars) {

    var cars = cars
        private set

    fun win(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}
