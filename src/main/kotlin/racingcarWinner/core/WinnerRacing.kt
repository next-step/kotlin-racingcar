package racingcarWinner.core

import java.lang.IllegalArgumentException

class WinnerRacing {
    var cars: List<Car> = mutableListOf()
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
            car.moveStep
        }
    }

    companion object {
        const val INIT_TRY_NUMBER = 1
    }
}
