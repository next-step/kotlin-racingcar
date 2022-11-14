package racingcar.domain.carRacing

class CarManager {
    fun ready(carNames: List<String>): List<Car> {
        return carNames.map { Car(it) }
    }
}
