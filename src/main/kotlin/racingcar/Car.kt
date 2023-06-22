package racingcar

class Car(var name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    init {
        require(name.length > 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(condition: Int) {
        if (condition >= MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val MOVE_CONDITION: Int = 4
    }
}
