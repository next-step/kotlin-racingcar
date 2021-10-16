package racingcar.domain.strategy

const val MOVING_CRITERIA = 4

fun interface MovingStrategy {
    fun isMovable(): Boolean
}
