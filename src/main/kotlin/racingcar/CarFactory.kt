package racingcar

object CarFactory {
    fun makeCars(carNames: List<String>): List<Car> =
        List(carNames.size) { x -> Car(carNames[x]) }
}
