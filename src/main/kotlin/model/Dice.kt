package model

import kotlin.random.Random

class Dice : DiceStatus {
    override fun dice(): Int {
        return Random.nextInt(DICE_MIN_VALUE, DICE_MAX_VALUE)
    }

    override fun isSuccess(): Boolean {
        return dice() > DICE_CHECK_SUCCESS_CONDITION
    }

    companion object {
        const val DICE_MIN_VALUE = 0
        const val DICE_MAX_VALUE = 9
        const val DICE_CHECK_SUCCESS_CONDITION = 4
    }
}
