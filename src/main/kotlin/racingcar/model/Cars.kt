package racingcar.model

class Cars {
    val cars: MutableList<Car> = mutableListOf()

    fun addCar(car: Car) {
        cars.add(car)
    }

    fun move() {
        cars.forEach { it.move() }
    }
}
