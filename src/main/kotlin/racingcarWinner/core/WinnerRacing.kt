package racingcarWinner.core

class WinnerRacing {
    fun setCars(carNames: List<String>): List<Car> =
        carNames.map { carName ->
            Car(carName.trim())
        }

    fun startRacing(cars: List<Car>, winner: Winner, tryNumber: Int): Map<String, Int> {
        require(cars.count() > MIN_CAR_NUMBER) { MessageCode.CarNumberException.message }
        require(tryNumber >= INIT_TRY_NUMBER) { MessageCode.TryNumberException.message }

        val carMap = mutableMapOf<String, Int>()

        cars.forEach { car ->
            car.move(Util.getRandomNumber())
            winner.setMaxMoveStep(car.moveStep)
            carMap[car.carName] = car.moveStep
        }
        return carMap
    }

    companion object {
        const val INIT_TRY_NUMBER = 1
        const val MIN_CAR_NUMBER = 1
    }
}
