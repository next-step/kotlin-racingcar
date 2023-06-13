package racing.domain

class Car(
    val name: String,
    position: Int = 0,
) {
    var position: Int = position
        private set

    init {
        require(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 ${MAX_NAME_LENGTH}자 이하여야 합니다" }
    }

    fun move(movePolicy: MovePolicy) {
        if (movePolicy.isMovable()) {
            position += 1
        }
    }

    fun hasSamePosition(other: Car): Boolean {
        return position == other.position
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}
