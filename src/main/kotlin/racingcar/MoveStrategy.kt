package racingcar

interface MoveStrategy {
    fun isPossibleMove(): Boolean
    fun getDistance(): Int
}
