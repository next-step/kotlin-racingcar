package step3

import kotlin.random.Random

class MoveDecisionMaker(private val random: Random = Random) {

    fun getRandomDigit(): Int = random.nextInt(10)

    fun canMove(digit: Int = getRandomDigit()): Boolean = digit > 4
}
