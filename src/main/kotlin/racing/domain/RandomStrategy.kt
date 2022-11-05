package racing.domain

import java.util.*

class RandomStrategy : MoveStrategy {
    private val randomNumber: Int
        private get() = random.nextInt(10)

    override fun canMove(): Boolean {
        return randomNumber >= MOVE_BOUNDARY
    }

    companion object {
        private val random = Random()
        private const val MOVE_BOUNDARY = 4

        val instance = RandomStrategy()
    }
}
