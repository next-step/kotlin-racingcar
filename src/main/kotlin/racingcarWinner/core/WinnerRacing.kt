package racingcarWinner.core

import java.lang.IllegalArgumentException

class WinnerRacing {
    var maxMoveStep: Int = 0
        private set

    fun setCars(carNames: List<String>): List<Car> =
        carNames.map { carName ->
            Car(carName.trim())
        }

    fun startRacing(cars: List<Car>, tryNumber: Int): Map<String, Int> {
        if (cars.count() <= MIN_CAR_NUMBER) throw IllegalArgumentException(MessageCode.CarNumberException.message)
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

    companion object {
        const val INIT_TRY_NUMBER = 1
        const val MIN_CAR_NUMBER = 1
    }
}
