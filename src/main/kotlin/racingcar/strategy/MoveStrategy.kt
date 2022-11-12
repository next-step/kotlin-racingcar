package racingcar.strategy

interface MoveStrategy {
    fun isPossibleMove(): Boolean
    fun getDistance(): Int
}
