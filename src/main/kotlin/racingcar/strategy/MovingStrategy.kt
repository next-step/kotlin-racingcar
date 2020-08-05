package racingcar.strategy

class MovingStrategy : Strategy {
    override fun move(number: Int): Boolean = true
    override fun generateNumber(): Int = Int.MAX_VALUE
}
