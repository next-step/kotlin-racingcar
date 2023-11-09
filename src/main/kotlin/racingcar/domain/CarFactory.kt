package racingcar.domain

class CarFactory() {
    fun createCars(names: List<String>): List<Car> = names.map { Car(name = it) }
}
