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

    fun startRacing(tryNumber: Int): List<Int> {
        if (tryNumber < INIT_TRY_NUMBER) throw IllegalArgumentException(MessageCode.TryNumberException.message)

        return cars.map { car ->
            car.move(Util.getRandomNumber())
            val moveStep = car.moveStep
            setMaxMoveStep(moveStep)
            moveStep
        }
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
