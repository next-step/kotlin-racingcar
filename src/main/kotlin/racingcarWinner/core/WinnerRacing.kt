package racingcarWinner.core

class WinnerRacing {
    var maxMoveStep: Int = DEFAULT_MAX_MOVE_STEP
        private set

    fun setCars(carNames: List<String>): List<Car> =
        carNames.map { carName ->
            Car(carName.trim())
        }

    fun startRacing(cars: List<Car>, tryNumber: Int): Map<String, Int> {
        require(cars.count() > MIN_CAR_NUMBER) { MessageCode.CarNumberException.message }
        require(tryNumber >= INIT_TRY_NUMBER) { MessageCode.TryNumberException.message }

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
        private const val DEFAULT_MAX_MOVE_STEP = 0
    }
}
