package racingcar.domain

/**
 * 위치.
 */
class Position(val value: Int = 0) {
    init {
        require(value >= 0)
    }

    /**
     * 위치를 이동하고 리턴한다.
     */
    fun move(newPosition: Int): Position {
        return Position(value + newPosition)
    }
}
