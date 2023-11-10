package racingcar.domain

object CarFactory {
    fun createCars(names: List<String>): List<Car> = names.map { Car(name = it) }
}
