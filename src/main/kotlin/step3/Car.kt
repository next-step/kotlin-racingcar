package step3

class Car(val minimumValueForMove: Int) {
    var movedDistance = 0
    fun move() {
        movedDistance++
    }
}
