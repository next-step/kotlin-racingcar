package racingcar.domain

import racingcar.domain.ExceptionType.CAR_NAME_LIMIT_LENGTH_OVER

class Car(private val minimumValueForMove: Int, val carName: String = "NONE") {
    var movedDistance = 0
        private set

    init {
        require(carName.length <= NAME_LENGTH_LIMIT) { "$CAR_NAME_LIMIT_LENGTH_OVER ($carName)" }
    }

    fun isMoveAble(valueToCheck: Int) =
        minimumValueForMove <= valueToCheck

    fun move(randomValue: Int) {
        if (!isMoveAble(randomValue))
            return
        movedDistance++
    }

    companion object {
        private const val NAME_LENGTH_LIMIT = 5
    }
}
