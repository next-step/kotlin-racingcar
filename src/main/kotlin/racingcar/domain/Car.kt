package racingcar.domain

class Car(
    val name: String,
    position: Int = INIT_POSITION
) {
    var position: Int = position
        private set

    init {
        check(name.length <= MAX_NAME_LENGTH) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    fun move(condition: Int) {
        if (condition >= CONDITION_TO_MOVE) {
            position++
        }
    }

    fun copy(): Car = Car(name, position)

    companion object {
        private const val INIT_POSITION: Int = 0
        private const val CONDITION_TO_MOVE: Int = 4
        private const val MAX_NAME_LENGTH: Int = 5
    }
}
