package racingcar.domain

import racingcar.view.CarDto

class Cars(carNames: List<String>) : List<Car> by (carNames.map { name -> Car(name) }) {

    fun winners(attemptCount: Int): List<Car> {
        val maxPosition = map { car -> car.currentPosition(attemptCount) }.maxOrNull()
        return filter { car -> car.currentPosition(attemptCount) == maxPosition }
    }

    fun moveOrStopAll(shouldMove: () -> Boolean) {
        forEach { car -> car.moveOrStop(shouldMove()) }
    }

    fun results(attempt: Int): List<CarDto> {
        return map { car -> CarDto(car.name, car.currentPosition(attempt)) }
    }
}
