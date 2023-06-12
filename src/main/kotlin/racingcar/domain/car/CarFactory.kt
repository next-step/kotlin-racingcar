package racingcar.domain.car

object CarFactory {
    fun getCars(carNames: List<String>): List<Car> = carNames.map { Car(it) }
}
