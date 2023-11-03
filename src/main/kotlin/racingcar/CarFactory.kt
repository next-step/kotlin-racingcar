package racingcar

class CarFactory {
    fun createsCars(carNames: List<String>): Cars {
        return Cars(carNames.map { Car(it) })
    }
}
