package racingcar.strategy

class RandomStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        return (MIN_CONDITION_VALUE..MAX_CONDITION_VALUE).random() >= THRESHOLD
    }

    companion object {
        const val THRESHOLD = 4
        const val MIN_CONDITION_VALUE = 0
        const val MAX_CONDITION_VALUE = 9
    }
}
