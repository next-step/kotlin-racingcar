package racingcarWinner.core

import java.lang.IllegalArgumentException

class WinnerRacing {
    var cars: List<Car> = mutableListOf()
        private set

    var maxMoveStep: Int = 0
        private set

    fun setCars(carNames: List<String>) {
        cars = carNames.map { carName ->
            Car(carName.trim())
        }
    }

    fun startRacing(tryNumber: Int): Map<String, Int> {
        if (tryNumber < INIT_TRY_NUMBER) throw IllegalArgumentException(MessageCode.TryNumberException.message)
        val carMap = mutableMapOf<String, Int>()
        cars.forEach { car ->
            car.move(Util.getRandomNumber())
            setMaxMoveStep(car.moveStep)
            carMap[car.carName] = car.moveStep
        }
        return carMap
    }

    private fun setMaxMoveStep(moveStep: Int) {
        if (moveStep > maxMoveStep) maxMoveStep = moveStep
    }

    fun getWinner(carsList: List<Car>, maxMoveStep: Int): List<String> =
        carsList.filter { car -> car.moveStep == maxMoveStep }.map { it.carName }

    companion object {
        const val INIT_TRY_NUMBER = 1
    }
}
