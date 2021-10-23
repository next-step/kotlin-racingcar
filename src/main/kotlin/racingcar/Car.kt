package racingcar

class Car(private val minimumValueForMove: Int) {
    private var movedDistance = 0

    fun isMoveAble(valueToCheck: Int) =
        minimumValueForMove <= valueToCheck

    fun move(randomValue: Int) {
        if (isMoveAble(randomValue))
            movedDistance++
    }

    fun getMovedDistance() = movedDistance
}
