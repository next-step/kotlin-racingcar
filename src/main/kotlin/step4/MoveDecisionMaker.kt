package step4

import kotlin.random.Random

class MoveDecisionMaker(private val random: Random = Random) {
    companion object {
        const val MAX_RANDOM_VALUE = 9
        const val MOVE_DECISION_CRITERIA = 4
    }

    fun getRandomDigit(): Int = random.nextInt(MAX_RANDOM_VALUE + 1)

    fun canMove(digit: Int = getRandomDigit()): Boolean = digit > MOVE_DECISION_CRITERIA
}
