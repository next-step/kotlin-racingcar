package racingcar.domain.strategy

interface MoveStrategy {
    fun isPossibleMove(): Boolean
    fun getDistance(): Int
}
