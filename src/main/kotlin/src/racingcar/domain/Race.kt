package src.racingcar.domain

class Race(cars: List<Car>) {
    var cars: List<Car> = cars
        private set

    fun start(): List<Car> {
        cars.forEach { it.move() }

        return cars
    }

    companion object {
        fun create(carNames: List<String>): Race {
            val cars = buildList {
                carNames.forEach { this.add(Car(it)) }
            }
            return Race(cars)
        }
    }
}
