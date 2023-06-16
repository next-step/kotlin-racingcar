package racingcar.domain

object CarFactory {
    fun manufacture(carNames: List<String>): List<Car> {
        return carNames.map {
            Car(it)
        }
    }
}
