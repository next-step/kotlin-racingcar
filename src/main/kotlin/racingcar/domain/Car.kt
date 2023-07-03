package racingcar.domain

class Car(name: String) {
    var position: Int = DEFAULT_POSITION
        private set

    var carName: CarName = CarName(name)
        private set

    var isWinner: Boolean = false

    fun move(condition: Int) {
        if (isWinner || condition >= MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val MOVE_CONDITION: Int = 4
    }
}

class CarName(val name: String) {

    init {
        require(name.length <= MAX_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    companion object {
        private const val MAX_LENGTH: Int = 5
    }
}
