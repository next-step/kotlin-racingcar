package study.racinggame.domain

class Car(
    _position: Int = 0,
    val name: String
) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    private var position = _position

    fun moveForward(moveAble: Boolean) {
        if (moveAble) position += 1
    }

    fun position() = position
}
