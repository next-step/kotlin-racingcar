package racing.v1

class Car {
    var position: Int = 0
        private set

    fun moveForward(number: Int) {
        if (DrivingPolicy.canMoveForward(number)) {
            position++
        }
    }
}
