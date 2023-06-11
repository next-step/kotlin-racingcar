package race.model

class Car(
    private val name: String,
    private val moveCondition: MoveCondition,
) {
    var position: Int = 0
        private set

    init {
        validate()
    }

    fun copyRecord(): CarRecord {
        return CarRecord(name, position)
    }

    fun move() {
        if (moveCondition.canGoStraight()) {
            straight()
        }
    }

    private fun validate() {
        if (5 < name.length) {
            throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
        }
    }

    private fun straight() {
        position++
    }
}
