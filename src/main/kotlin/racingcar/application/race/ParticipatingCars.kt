package racingcar.application.race

import racingcar.domain.car.Car

class ParticipatingCars(
    private val carList: List<Car>
) {
    fun sizeRange(): IntRange = IntRange(START_NUMBER, this.carList.size)
    fun move(outputFunction: (Int) -> Unit) {
        carList.forEach {
            it.move()
            outputFunction(it.currentPosition().toInt())
        }
    }

    private companion object {
        private const val START_NUMBER = 1
    }
}
