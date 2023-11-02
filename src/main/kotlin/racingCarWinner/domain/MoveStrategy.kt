package racingCarWinner.domain

interface MoveStrategy {
    fun isMovable(): Boolean
}