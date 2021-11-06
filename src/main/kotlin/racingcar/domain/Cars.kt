package racingcar.domain

class Cars {

    var cars = mutableListOf<Car>()
        private set

    fun addCar(car: Car) {
        cars.add(car)
    }

    fun race(strategy: NumberStrategy) {
        cars.forEach { car -> car.move(strategy.getNumber()) }
    }
}