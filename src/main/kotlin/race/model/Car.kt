package race.model

class Car(
    private val name: String,
    private val moveCondition: MoveCondition,
) {
    init {
        validate()
    }

    var position: Int = 0
        private set

    private fun validate() {
        if (5 < name.length) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
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
}
