package step4

import kotlin.random.Random

class MoveDecisionMaker(private val random: Random = Random) {

    fun getRandomDigit(): Int = random.nextInt(MAX_RANDOM_VALUE + 1)

    fun canMove(digit: Int = getRandomDigit()): Boolean = digit > MOVE_DECISION_CRITERIA

    companion object {
        private const val MAX_RANDOM_VALUE = 9
        private const val MOVE_DECISION_CRITERIA = 4
    }
}
