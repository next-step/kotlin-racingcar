package step4

import step4.domain.MoveStrategy

class FixedStrategy(override val count: Int) : MoveStrategy {
    override fun isMoveSuccess(): Boolean {
        return count >= 4
    }
}
