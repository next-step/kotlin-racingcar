package racingcar.view

import racingcar.common.ViewMessage

object InputView {
    fun readNumberCars() {
        println(ViewMessage.ASK_NUMBER_CARS_MESSAGE.viewMessage)
    }

    fun readTryCount() {
        println(ViewMessage.ASK_TRY_COUNT_MESSAGE.viewMessage)
    }
}
