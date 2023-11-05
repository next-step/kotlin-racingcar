package racing_car.domain

class Car(
    name: String,
    position: Int = 0,
    private val moveStrategy: MoveStrategy = RandomAboveThresholdMoveStrategy(),
) {

    var carInfo = CarInfo(name = name, position = position)
        private set

    val name: String
        get() = carInfo.name

    val position: Int
        get() = carInfo.position

    fun move() {
        if (moveStrategy.canMove()) {
            carInfo = carInfo.copy(position = carInfo.position + 1)
        }
    }
}
