package racingcar.domain.car

object CarFactory {
    fun create(nameOfCars: List<String>): List<Car> =
        nameOfCars.map {
            Car(name = it)
        }
}
