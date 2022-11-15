package racingcar.controller

class Car(var currentPosition: Int = 0) {

    fun move(nextMovement: Int) {
        currentPosition += nextMovement
    }
}
