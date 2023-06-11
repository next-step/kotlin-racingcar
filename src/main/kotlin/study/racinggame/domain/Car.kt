package study.racinggame.domain

class Car(
    _position: Int = DEFAULT_POSITION,
    val name: String
) {

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    private var position = _position

    fun moveForward(moveAble: Boolean) {
        if (moveAble) position += 1
    }

    companion object {
        const val DEFAULT_POSITION: Int = 1
        const val MAX_NAME_LENGTH: Int = 5
    }
}
