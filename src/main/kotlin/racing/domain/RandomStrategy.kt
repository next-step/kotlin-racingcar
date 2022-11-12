package racing.domain

import kotlin.random.Random.Default.nextInt

class RandomStrategy : MoveStrategy {
    private val randomNumber: Int
        private get() = nextInt(10)

    override fun canMove(): Boolean {
        return randomNumber >= MOVE_BOUNDARY
    }

    companion object {
        private const val MOVE_BOUNDARY = 4

        val instance = RandomStrategy()
    }
}
