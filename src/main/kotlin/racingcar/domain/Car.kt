package racingcar.domain

import java.lang.IllegalArgumentException

class Car {
    private var location = 0
    private val BASE_NUMBER_TO_MOVE = 4
    private val RANDOM_MINIMUM = 0
    private val RANDOM_MAXIMUM = 9

    fun isMoveOrStop() {
        val randomNum = generateRandomNum()
        if (conditionToMove(randomNum)) location++
    }

    private fun conditionToMove(randomNum: Int) = randomNum >= BASE_NUMBER_TO_MOVE

    private fun generateRandomNum(): Int {

        val randomValue: Int = (RANDOM_MINIMUM..RANDOM_MAXIMUM).random()
        if (randomValue < RANDOM_MINIMUM || randomValue > RANDOM_MAXIMUM) {
            throw IllegalArgumentException()
        }
        return randomValue
    }

    fun printLocation() {
        for (i in 0 until location) {
            print("-")
        }
        println()
    }
}
