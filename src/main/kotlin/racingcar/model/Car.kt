package racingcar.model

private const val MOVE_THRESHOLD = 4
private const val MINIMUM_SCORE = 0
private const val MAXIMUM_SCORE = 9

class Car(val position: Position = Position()) {

    fun move(score: Int) {
        require(score in (MINIMUM_SCORE..MAXIMUM_SCORE))
        if (score >= MOVE_THRESHOLD) {
            position.increase()
        }
    }

    fun repeatForEachPosition(consumer: () -> Unit) = repeat(position.value) { consumer() }
}
