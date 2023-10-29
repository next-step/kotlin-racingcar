package racingcar.domain

enum class MovingDirection(positionNumber: Int) {
    FORWARD(1),
    STOP(0);

    val position = Position(positionNumber)
}
