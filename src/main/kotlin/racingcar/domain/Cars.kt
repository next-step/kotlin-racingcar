package racingcar.domain

class Cars(carNames: List<String>) : List<Car> by (carNames.map { name -> Car(name) }) {

    fun winners(attemptCount: Int): List<Car> {
        val maxPosition = maxByOrNull { car -> car.currentPosition(attemptCount) }
            ?.currentPosition(attemptCount)
        return filter { car -> car.currentPosition(attemptCount) == maxPosition }
    }
}
