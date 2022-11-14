package racingcar.domain


class Car(
    val position: Position = Position(POSITION_FIRST),
) {

    fun move(): Car {
        return Car(Position(position.value + POSITION_MOVE))
    }

    companion object {
        private const val POSITION_FIRST = 1
        private const val POSITION_MOVE = 1
    }

}