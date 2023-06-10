package study.racinggame.domain

class Car(
    _position: Int = 0
) {

    private var position = _position

    fun moveForward(moveAble: Boolean) {
        if (moveAble) position += 1
    }

    fun position() = position
}
