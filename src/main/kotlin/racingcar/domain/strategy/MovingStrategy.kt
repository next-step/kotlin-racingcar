package racingcar.domain.strategy

const val MOVE_CONSTRAINTS = 4

interface MovingStrategy {
    fun movable(): Boolean
}
