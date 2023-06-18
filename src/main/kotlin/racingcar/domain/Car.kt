package racingcar.domain

class Car(val name: String, position: Int = 0, private val moveStrategy: MoveStrategy = MoveStrategy { true }) {

    init {
        require(name.isNotBlank()) { "자동차의 이름은 공백일 수 없습니다." }
        require(name.length <= CAR_NAME_LENGTH_LIMIT) { "자동차의 이름은 ${CAR_NAME_LENGTH_LIMIT}자를 초과할 수 없다." }
    }

    var position = position
        private set

    fun move() {
        if (moveStrategy.isMovable())
            position++
    }

    companion object {
        private const val CAR_NAME_LENGTH_LIMIT = 5
    }
}
