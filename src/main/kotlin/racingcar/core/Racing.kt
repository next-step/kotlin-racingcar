package racingcar.core

import racingcar.ui.MessageCode
import java.lang.IllegalArgumentException

class Racing {
    fun startRacing(carNumber: Int, tryNumber: Int): List<String> {
        if (tryNumber < Car.INIT_TRY_NUMBER) throw IllegalArgumentException(MessageCode.TryNumberException.message)
        if (carNumber < Car.INIT_CAR_NUMBER) throw IllegalArgumentException(MessageCode.CarNumberException.message)
        return (Car.INIT_TRY_NUMBER..carNumber).map {
            Car(tryNumber).move()
        }
    }
}
