package racingcar

import racingcar.ExceptionType.CAR_NAME_LIMIT_LENGTH_OVER

class Car(private val minimumValueForMove: Int, val carName: String = "NONE") {
    private val nameLengthLimit = 5

    init {
        require(carName.length <= nameLengthLimit) { CAR_NAME_LIMIT_LENGTH_OVER }
    }

    private var movedDistance = 0

    fun isMoveAble(valueToCheck: Int) =
        minimumValueForMove <= valueToCheck

    fun move(randomValue: Int) {
        if (isMoveAble(randomValue))
            movedDistance++
    }

    fun getMovedDistance() = movedDistance
}
