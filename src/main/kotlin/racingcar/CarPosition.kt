package racingcar

data class CarPosition private constructor(
    val name: CarName,
    val position: Position,
) {
    companion object {
        fun from(car: Car): CarPosition {
            return CarPosition(
                name = car.name,
                position = car.position,
            )
        }
    }
}
