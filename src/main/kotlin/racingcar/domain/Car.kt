package racingcar.domain

class Car(
    val name: String,
    moveCount: Int = 0
) {
    var moveCount: Int = moveCount
        private set

    init {
        require(name.length <= NAME_MAX_LENGTH) {
            "{$name}의 길이는 ${NAME_MAX_LENGTH}를 초과할 수 없습니다."
        }
    }

    fun move(condition: Int) {
        if (condition >= MOVE_THRESHOLD) {
            moveCount++
        }
    }

    fun copy(): Car {
        return Car(name, moveCount)
    }

    companion object {
        const val MOVE_THRESHOLD = 4
        const val NAME_MAX_LENGTH = 5
    }
}
