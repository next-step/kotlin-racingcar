package racingcar.controller

class Car {
    var currentPosition: Int = 0
        private set

    fun move(nextMovement: Int) {
        currentPosition += nextMovement
    }
}
