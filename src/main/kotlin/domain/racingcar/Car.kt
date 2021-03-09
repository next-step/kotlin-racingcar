package domain.racingcar

class Car(val name: String, val position: Position = Position()) {
    init {
        require(name.length < MAX_NAME_LENGTH) { throw IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.") }
    }

    fun forward() {
        position.forward()
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
