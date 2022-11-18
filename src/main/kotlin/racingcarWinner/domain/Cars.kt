package racingcarWinner.domain

import racingcarWinner.util.MessageCode

class Cars(carNames: List<String>) {
    val carList: List<Car> = carNames.map { Car(it.trim()) }

    init {
        require(carList.count() > MIN_CAR_NUMBER) { MessageCode.CarNumberException.message }
    }

    private fun getMaxMoveStep(): Int =
        carList.maxOf { it.moveStep }

    fun findMaxMoveStepCarNameList(): List<String> =
        carList.filter { car -> car.moveStep == getMaxMoveStep() }.map { it.carName }

    companion object {
        const val MIN_CAR_NUMBER = 1
    }
}
