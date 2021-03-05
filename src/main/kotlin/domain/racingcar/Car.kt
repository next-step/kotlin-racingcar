package domain.racingcar

class Car(val name: String) {
    init {
        require(name.length < MAX_NAME_LENGTH) { throw IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.") }
    }

    var position: Position = Position()
        private set

    fun forward() {
        position.forward()
    }

    companion object {
        private const val MAX_NAME_LENGTH = 6
    }
}
