package study.racinggame.domain

class Car(
    var position: Int = 0
) {
    fun moveForward(randomNumber: Int) {
        if (randomNumber > FORWARD_THRESHOLD) position += 1
    }

    fun moveForward(moveAble: Boolean) {
        if (moveAble) position += 1
    }
}
