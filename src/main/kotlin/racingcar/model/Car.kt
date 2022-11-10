package racingcar.model

private const val DEFAULT_POSITION = 1
private const val MOVE_THRESHOLD = 4
private const val MINIMUM_SCORE = 0
private const val MAXIMUM_SCORE = 9

class Car(var position: Int = DEFAULT_POSITION) {

    init {
        require(position >= DEFAULT_POSITION)
    }

    fun move(score: Int) {
        require(score in (MINIMUM_SCORE..MAXIMUM_SCORE))
        if (score >= MOVE_THRESHOLD) {
            position++
        }
    }
}
