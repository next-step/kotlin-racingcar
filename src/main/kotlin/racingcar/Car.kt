package racingcar

class Car(val name: String) {
    init {
        require(name.length < MAX_NAME_LENGTH) { throw IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.") }
    }

    var position: Int = START_POSITION
        private set

    fun forward() {
        position++
    }

    companion object {
        private const val START_POSITION = 0
        private const val MAX_NAME_LENGTH = 6
    }
}
