package racingcar

class DefaultMoveStrategy : MoveStrategy {

    override fun isMove(): Boolean = (0..9).random() >= PIVOT_NUMBER

    companion object {
        private const val PIVOT_NUMBER = 4
    }
}
