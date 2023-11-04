package racing_car.domain

class Car(
    val name: String,
    position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomAboveThresholdMoveStrategy(),
) {

    init {
        require(name.length <= 5) { "자동차 이름은 5자를 초과할 수 없습니다." }
    }

    var position: Int = position
        private set

    fun move() {
        if (moveStrategy.canMove()) {
            position++
        }
    }

    fun copy(): Car {
        return Car(name = name, position = position, moveStrategy = moveStrategy)
    }
}
