package racingcar

class Car(val number: Int, var position: Int = 0) {
    fun moveForward(carMoveForwardDecider: CarMoveForwardDecider) {
        if (carMoveForwardDecider.canMoveForward()) {
            position++
        }
    }
}
