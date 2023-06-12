package racingcar.car

object CarFactory {
    fun getCars(carNames: List<String>): List<Car> = carNames.map { Car(it) }
}
