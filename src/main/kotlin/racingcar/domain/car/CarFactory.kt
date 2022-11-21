package racingcar.domain.car

object CarFactory {
    fun create(nameOfCars: Set<String>): List<Car> =
        nameOfCars.map {
            Car(name = it)
        }
}
