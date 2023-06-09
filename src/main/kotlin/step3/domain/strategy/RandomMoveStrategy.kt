package step3.domain.strategy

object RandomMoveStrategy : MoveStrategy {
    override fun movable(): Boolean {
        val random = (0 until 10).random()
        return random >= 4
    }
}
