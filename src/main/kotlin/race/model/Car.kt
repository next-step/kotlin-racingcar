package race.model

class Car(
    private val name: String,
    private val moveCondition: MoveCondition,
) {
    var position: Int = 0
        private set

    init {
        require(name.length <= MAX_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    fun copyRecord(): CarRecord {
        return CarRecord(name, position)
    }

    fun move() {
        if (moveCondition.canGoStraight()) {
            straight()
        }
    }

    private fun straight() {
        position++
    }

    companion object {
        const val MAX_LENGTH = 5
    }
}
