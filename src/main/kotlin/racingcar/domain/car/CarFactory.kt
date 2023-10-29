package racingcar.domain.car

object CarFactory {
    fun createCars(names: List<String>): List<Car> {
        return names.map { Car(name = it) }
    }
}
