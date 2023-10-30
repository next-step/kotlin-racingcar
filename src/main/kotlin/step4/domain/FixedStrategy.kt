package step4.domain

class FixedStrategy(override val count: Int) : MoveStrategy {
    override fun isMoveSuccess(): Boolean {
        return count >= 4
    }
}
