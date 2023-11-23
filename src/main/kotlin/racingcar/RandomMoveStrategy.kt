package racingcar

class RandomMoveStrategy : MoveStrategy {
    override fun move(): Int = (0..9).random()
}
