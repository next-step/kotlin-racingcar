package step4.strategy

import kotlin.random.Random

class ConditionalMoveStrategy : MoveStrategy {
    override fun getResultOfTurn(): Int {
        return successToMove()
    }

    private fun successToMove(): Int {
        val random = getRandomNumber()

        return if (random >= MIN_VALUE_TO_MOVE) SUCCESS_TO_MOVE else FAIL_TO_MOVE
    }

    private fun getRandomNumber(): Int {
        return Random.nextInt(10)
    }

    companion object {
        private const val MIN_VALUE_TO_MOVE = 4

        const val SUCCESS_TO_MOVE = 1
        private const val FAIL_TO_MOVE = 0
    }
}
