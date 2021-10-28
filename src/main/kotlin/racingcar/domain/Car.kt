package racingcar.domain

import racingcar.exception.BizException
import racingcar.exception.message.input.InputErrorMessage

class Car(
    val carName: String
) {

    var distance = 0
        private set // setter 를 감추는 방법

    init {
        require(carName.length <= NAME_LENGTH_LIMIT) { BizException.InputException(InputErrorMessage.CAR_NAME_LENGTH_OVER) }
    }

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
