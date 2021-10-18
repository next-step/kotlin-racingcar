package step3

val START_POSITION = 0

class Car {
    var position = START_POSITION

    fun moveForward() {
        if (Random.canMoveFoward()) {
            position++
        }
    }
}
