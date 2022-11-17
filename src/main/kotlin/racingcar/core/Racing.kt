package racingcar.core

import racingcar.ui.MessageCode
import java.lang.IllegalArgumentException

class Racing(carNumber: Int) {

    private var cars: List<Car> = mutableListOf()

    init {
        cars = setCars(carNumber)
    }

    private fun setCars(carNumber: Int): List<Car> {
        if (carNumber < INIT_CAR_NUMBER) throw IllegalArgumentException(MessageCode.CarNumberException.message)
        return (INIT_CAR_NUMBER..carNumber).map {
            Car()
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
        private const val INIT_CAR_NUMBER = 1
    }
}
