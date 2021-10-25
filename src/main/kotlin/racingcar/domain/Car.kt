package racingcar.domain

import racingcar.domain.ExceptionType.CAR_NAME_LIMIT_LENGTH_OVER

class Car(private val minimumValueForMove: Int = DEFAULT_MINIMUM_VALUE, val carName: String = "NONE") {
    var movedDistance = 0
        private set

    init {
        require(carName.length <= NAME_LENGTH_LIMIT) { "$CAR_NAME_LIMIT_LENGTH_OVER ($carName)" }
    }

    fun isMoveAble(valueToCheck: Int) =
        minimumValueForMove <= valueToCheck

    fun moveToForward(randomValue: Int): Boolean {
        if (!isMoveAble(randomValue))
            return false
        movedDistance++
        return true
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
        private const val DEFAULT_MINIMUM_VALUE = 4
    }
}
