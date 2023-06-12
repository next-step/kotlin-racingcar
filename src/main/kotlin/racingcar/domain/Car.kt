package racingcar.domain

import java.lang.IllegalArgumentException

class Car {
    private var location = 0
    private val BASE_NUMBER_TO_MOVE = 4
    private val RANDOM_MINIMUM = 0
    private val RANDOM_MAXIMUM = 9

    fun isMoveOrStop(): Boolean {
        val randomNum = generateRandomNum()
        val conditionToMove = conditionToMove(randomNum)
        if (conditionToMove) location++
        return conditionToMove
    }

    private fun conditionToMove(randomNum: Int) = randomNum >= BASE_NUMBER_TO_MOVE

    fun generateRandomNum(): Int {

        val randomValue: Int = (RANDOM_MINIMUM..RANDOM_MAXIMUM).random()
        if (randomValue < RANDOM_MINIMUM || randomValue > RANDOM_MAXIMUM) {
            throw IllegalArgumentException()
        }
        return randomValue
    }

    fun getLocation(): Int {
        return location
    }
}
