package racingcar.domain

class Car(
    val name: String,
    position: Int = STARTING_POSITION,
) {
    init {
        require(name.length <= CAR_NAME_LENGTH_LIMIT) { "자동차 이름은 ${CAR_NAME_LENGTH_LIMIT}자를 초과할 수 없습니다" }
    }

    var position = position
        private set

    fun moveForward(carMovementDecider: CarMovementDecider) {
        if (carMovementDecider.canMove()) {
            position++
        }
    }

    companion object {
        private const val CAR_NAME_LENGTH_LIMIT = 5
        private const val STARTING_POSITION = 0
    }
}
