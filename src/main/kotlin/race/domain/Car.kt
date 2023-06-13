package race.domain

class Car(
    val name: String,
    val position: Int,
    private val moveCondition: MoveCondition,
) {

    constructor(name: String, moveCondition: MoveCondition) : this(name, 0, moveCondition)

    init {
        require(name.length <= MAX_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없습니다."
        }
    }

    fun move(): Car {
        if (moveCondition.canGoStraight()) {
            return straight()
        }
        return this
    }

    private fun straight(): Car {
        return Car(name, position + 1, moveCondition)
    }

    companion object {
        const val MAX_LENGTH = 5
    }
}
