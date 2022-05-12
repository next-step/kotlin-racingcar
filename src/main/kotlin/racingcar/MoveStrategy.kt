package racingcar

@FunctionalInterface
interface MoveStrategy {
    fun isMove(): Boolean
}
