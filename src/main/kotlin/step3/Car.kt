package step3

class Car(val minimumValueForMove: Int) {
    var movedDistance = 0

    fun isMoveAble(valueToCheck: Int) =
        minimumValueForMove <= valueToCheck

    fun move() {
        movedDistance++
    }
}
