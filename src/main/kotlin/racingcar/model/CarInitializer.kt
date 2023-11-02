package racingcar.model

object CarInitializer {
    fun createCars(namesOfCars: List<String>): List<Car> = namesOfCars.map { Car(name = it) }
}
