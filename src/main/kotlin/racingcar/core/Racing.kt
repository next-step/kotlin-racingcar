package racingcar.core

import racingcar.ui.MessageCode
import java.lang.IllegalArgumentException

object Racing {

    private const val INIT_TRY_NUMBER = 1
    private const val INIT_CAR_NUMBER = 1
    private const val SEPARATOR = " "

    val cars = mutableListOf<Car>()

    fun setCarInit() {
        cars.clear()
    }

    fun setCars(carNumber: Int) {
        if (carNumber < INIT_CAR_NUMBER) throw IllegalArgumentException(MessageCode.CarNumberException.message)
        (INIT_CAR_NUMBER..carNumber).map {
            cars.add(Car())
        }
    }

    fun startRacing(tryNumber: Int): List<String> {
        if (tryNumber < INIT_TRY_NUMBER) throw IllegalArgumentException(MessageCode.TryNumberException.message)

        return cars.map { car ->
            car.move(Util.getRandomNumber())
            car.moveStep.joinToString(SEPARATOR)
        }
    }
}
