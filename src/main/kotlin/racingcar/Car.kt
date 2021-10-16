package racingcar

class Car(val number: Int, var position: Int = 0) {
    fun goForward(carMoveForwardStrategy: CarMoveForwardStrategy) {
        if (carMoveForwardStrategy.canMoveForward()) {
            position++
        }
    }
}
