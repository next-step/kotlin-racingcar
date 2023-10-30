package racing

class Car {
    var position: Int = 0

    fun moveForward(number: Int) {
        if (DrivingPolicy.canMoveForward(number)) {
            position++
        }
    }
}
