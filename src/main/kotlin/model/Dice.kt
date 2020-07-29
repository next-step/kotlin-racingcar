package model

import kotlin.random.Random

class Dice : DiceStatus {
    override fun dice(): Int {
        return Random.nextInt(DICE_MIN_VALUE, DICE_MAX_VALUE)
    }

    override fun availableMove(diceValue: Int): Boolean {
        return diceValue > DICE_CHECK_SUCCESS_CONDITION
    }

    companion object {
        val DICE_MIN_VALUE = 0
        val DICE_MAX_VALUE = 9
        val DICE_CHECK_SUCCESS_CONDITION = 4
    }
}
