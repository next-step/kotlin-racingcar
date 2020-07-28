package model

import kotlin.random.Random

class Car {
    var step: Int = 0
    var stepList: MutableList<Int> = mutableListOf()

    fun diceMove() {
        if (availableMove(dice())) {
            step++
        }
        stepList.add(step)
    }

    private fun dice(): Int {
        return Random.nextInt(0, 9)
    }

    private fun availableMove(diceNum: Int) = diceNum > 4
}
