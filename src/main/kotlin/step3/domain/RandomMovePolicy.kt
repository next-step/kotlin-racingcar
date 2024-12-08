package step3.domain

class RandomMovePolicy : MovePolicy {
    override fun shouldMove(): Boolean {
        val randomInt = randomIntRange.random()
        return randomInt >= MOVE_STANDARD
    }

    companion object {
        private val randomIntRange = 0..9
        private const val MOVE_STANDARD = 4
    }
}
