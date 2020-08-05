package racingcar.strategy

class RandomStrategy : Strategy {
    override fun move(number: Int): Boolean = number > FORWARD_CONDITION

    override fun generateNumber() = (0..9).random()

    companion object {
        private const val FORWARD_CONDITION = 4
    }
}
