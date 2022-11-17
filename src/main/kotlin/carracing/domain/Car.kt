package carracing.domain

const val INIT_POSITION: Int = 1
const val MAX_CAR_LENGTH: Int = 5

class Car(var name: String, var position: Int = INIT_POSITION, val moveStrategy: MoveStrategy = RandomStrategy()) {

    init {
        require(name.length <= MAX_CAR_LENGTH) { "자동차 이름의 길이는 $MAX_CAR_LENGTH 이하여야 합니다." }
    }

    fun move(): Car {
        if (moveStrategy.isMovable()) position++
        return this
    }
}
