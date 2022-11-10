package racingcar.model

private const val MOVE_THRESHOLD = 4
private const val DEFAULT_SPEED = 1

class Car(val position: Position = Position()) {

    fun move(score: Score) {
        if (score.isBiggerThanOrEquals(MOVE_THRESHOLD)) {
            position.increase(DEFAULT_SPEED)
        }
    }
}
