package racingcar.domain

class Cars(carNames: List<String>) : List<Car> by (carNames.map { name -> Car(name) }) {

    fun winners(): List<Car> {
        val maxPosition = maxOfOrNull { it.currentPosition() }
        return filter { it.currentPosition() == maxPosition }
    }

    fun moveOrStopAll(shouldMove: () -> Boolean) {
        forEach { it.moveOrStop(shouldMove()) }
    }

    fun results(attempt: Int): List<CarPositionDto> {
        return map { CarPositionDto(it.name, it.position(attempt)) }
    }
}
