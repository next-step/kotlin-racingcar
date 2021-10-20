package racing

const val START_POSITION = 0

class Car(val canMoveForward: Random, val movingCondition: Int) {
    var position = START_POSITION

    fun moveForward() {
        if (canMoveForward(movingCondition)) {
            position++
        }
    }
}
