package racingcar.domain


class Car(
    val position: Position = Position(POSITION_FIRST),
) {

    fun moveCar(): Car {
        return Car(Position(position.value + POSITION_MOVE))
    }

    companion object {
        const val POSITION_FIRST = 1
        const val POSITION_MOVE = 1
    }

}