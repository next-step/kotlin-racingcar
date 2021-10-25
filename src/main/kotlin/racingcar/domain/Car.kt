package racingcar.domain

import racingcar.exception.BizException
import racingcar.exception.message.input.InputErrorMessage

class Car(
    val carName: String
) {

    init {
        require(carName.length <= NAME_LENGTH_LIMIT) { BizException.InputException(InputErrorMessage.CAR_NAME_LENGTH_OVER) }
    }

    var distance = 0

    fun forward(randomNumber: Int) {
        if (randomNumber >= MOVE_SUCCESS) distanceIncrease()
    }

    private fun distanceIncrease() {
        distance++
    }

    companion object {
        private const val MOVE_SUCCESS = 4
        private const val NAME_LENGTH_LIMIT = 5
    }
}
