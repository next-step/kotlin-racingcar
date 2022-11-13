package racing.domain

import kotlin.random.Random.Default.nextInt

class RandomStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        return nextInt(RANDOM_NUMBER_BOUNDARY) >= MOVE_BOUNDARY
    }

    companion object {
        private const val RANDOM_NUMBER_BOUNDARY = 10
        private const val MOVE_BOUNDARY = 4
        val instance = RandomStrategy()
    }
}
