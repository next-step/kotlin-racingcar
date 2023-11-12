package racing_car.domain

class Car(
    name: String,
    moveStrategy: MoveStrategy = RandomAboveThresholdMoveStrategy(),
    position: Int = 0,
) {

    var position: Int = position
        private set

    private var carInfo = CarInfo(name = name, moveStrategy = moveStrategy)

    val name: String
        get() = carInfo.name

    fun isWin(other: Car): Boolean {
        return this.position > other.position
    }

    fun isDraw(other: Car): Boolean {
        return this.position == other.position
    }

    fun move() {
        if (carInfo.moveStrategy.canMove()) {
            position++
        }
    }
}
