package racing.domain

class Winner(cars: Cars) {

    var cars = cars
        private set

    fun win(): List<Car> = cars.isWinner()
}
