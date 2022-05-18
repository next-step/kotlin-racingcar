package game.racingcar.strategy

fun interface MoveStrategy {
    fun move(current: Int): Int
}
