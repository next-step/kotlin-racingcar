package racingcar.model

object Cars {
    fun create(namesOfCars: List<String>): List<Car> = namesOfCars.map { Car(it) }
}
